package id.vincenttp.ajaibtest.data.repository

import id.vincenttp.ajaibtest.base.AppConstant
import id.vincenttp.ajaibtest.data.ApiService
import id.vincenttp.ajaibtest.data.mapper.toDb
import id.vincenttp.ajaibtest.data.mapper.toModel
import id.vincenttp.ajaibtest.data.room.AppDatabase
import id.vincenttp.ajaibtest.data.room.entity.SearchEntity
import id.vincenttp.ajaibtest.domain.domain.UserRepository
import id.vincenttp.ajaibtest.domain.model.RepositoryModel
import id.vincenttp.ajaibtest.domain.model.UserModel
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val db: AppDatabase
) : UserRepository {
    override suspend fun getUsers(q: String, page: Int): List<UserModel> {
        val searchEntity = db.searchDao().loadAllByIds(q + page)

        return if (searchEntity != null) {
            getUsersLocal(searchEntity)
        } else {
            // save to db
            val result = api.getUsers(q, page)
            db.searchDao().insertAll(result.toDb(q, page))

            result.items.map {
                db.userDao().insertAll(it.toDb())
                it.toModel()
            }
        }
    }

    override suspend fun getUser(username: String): UserModel {
        val userEntity = db.userDao().loadAllByIds(username)

        return if (userEntity != null && userEntity.name.isNotEmpty()) {
            userEntity.toModel()
        } else {
            val result = api.getUser(username)
            db.userDao().update(result.toDb())
            result.toModel()
        }
    }

    override suspend fun getRepositories(username: String): List<RepositoryModel> =
        api.getRepositories(username).map {
            it.toModel()
        }


    private fun getUsersLocal(searchEntity: SearchEntity): List<UserModel> {
        return searchEntity.result.split(AppConstant.SEPARATOR_DB).map {
            db.userDao().loadAllByIds(it).toModel()
        }
    }
}