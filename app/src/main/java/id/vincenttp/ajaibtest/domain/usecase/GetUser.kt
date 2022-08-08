package id.vincenttp.ajaibtest.domain.usecase

import id.vincenttp.ajaibtest.base.BaseUseCase
import id.vincenttp.ajaibtest.domain.domain.UserRepository
import id.vincenttp.ajaibtest.domain.model.UserModel
import javax.inject.Inject

class GetUser @Inject constructor(
    private val repository: UserRepository
) : BaseUseCase<UserModel, GetUser.Params>() {

    data class Params(
        val username: String
    )

    override suspend fun build(params: Params): UserModel = repository.getUser(
        username = params.username
    )
}