package id.vincenttp.ajaibtest.domain.usecase

import id.vincenttp.ajaibtest.base.BaseUseCase
import id.vincenttp.ajaibtest.domain.domain.UserRepository
import id.vincenttp.ajaibtest.domain.model.UserModel
import javax.inject.Inject

class SearchUsers @Inject constructor(
    private val repository: UserRepository
) : BaseUseCase<List<UserModel>, SearchUsers.Params>() {

    data class Params(
        val q: String,
        val page: Int
    )

    override suspend fun build(params: Params): List<UserModel> = repository.getUsers(
        q = params.q,
        page = params.page
    )
}