package id.vincenttp.ajaibtest.data

import id.vincenttp.ajaibtest.data.response.RepositoriesResponse
import id.vincenttp.ajaibtest.data.response.SearchResponse
import id.vincenttp.ajaibtest.data.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    suspend fun getUsers(
        @Query("q") q: String,
        @Query("page") page: Int
    ): SearchResponse

    @GET("users/{username}")
    suspend fun getUser(
        @Path("username") username: String
    ): UserResponse

    @GET("users/{username}/repos")
    suspend fun getRepositories(
        @Path("username") username: String
    ): List<RepositoriesResponse>
}