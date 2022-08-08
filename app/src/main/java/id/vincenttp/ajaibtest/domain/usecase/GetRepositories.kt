package id.vincenttp.ajaibtest.domain.usecase

import id.vincenttp.ajaibtest.base.BaseUseCase
import id.vincenttp.ajaibtest.domain.domain.UserRepository
import id.vincenttp.ajaibtest.domain.model.RepositoryModel
import javax.inject.Inject

class GetRepositories @Inject constructor(
    private val repository: UserRepository
) : BaseUseCase<List<RepositoryModel>, GetRepositories.Params>() {

    data class Params(
        val username: String
    )

    override suspend fun build(params: Params): List<RepositoryModel> = repository.getRepositories(
        username = params.username
    )
}