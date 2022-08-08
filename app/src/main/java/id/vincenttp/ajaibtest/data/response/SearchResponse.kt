package id.vincenttp.ajaibtest.data.response

import com.squareup.moshi.Json

data class SearchResponse(
    @Json(name = "items")
    val items: List<UserResponse>
){
    data class UserResponse(
        @Json(name = "login") val login: String?,
        @Json(name = "id") val id: Int?,
        @Json(name = "avatar_url") val avatar_url: String?
    )
}
