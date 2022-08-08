package id.vincenttp.ajaibtest.domain.domain

import id.vincenttp.ajaibtest.domain.model.RepositoryModel
import id.vincenttp.ajaibtest.domain.model.UserModel

interface UserRepository {
    suspend fun getUsers(q: String, page: Int): List<UserModel>
    suspend fun getUser(username: String): UserModel
    suspend fun getRepositories(username: String): List<RepositoryModel>
}