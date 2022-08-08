package id.vincenttp.ajaibtest.data.mapper

import android.annotation.SuppressLint
import android.text.format.DateUtils
import id.vincenttp.ajaibtest.base.AppConstant
import id.vincenttp.ajaibtest.data.response.RepositoriesResponse
import id.vincenttp.ajaibtest.data.response.SearchResponse
import id.vincenttp.ajaibtest.data.response.UserResponse
import id.vincenttp.ajaibtest.data.room.entity.SearchEntity
import id.vincenttp.ajaibtest.data.room.entity.UserEntity
import id.vincenttp.ajaibtest.domain.model.RepositoryModel
import id.vincenttp.ajaibtest.domain.model.UserModel
import java.text.SimpleDateFormat

fun SearchResponse.UserResponse?.toModel() = UserModel(
    avatar = this?.avatar_url.orEmpty(),
    username = this?.login.orEmpty()
)

fun UserResponse?.toModel() = UserModel(
    avatar = this?.avatarUrl.orEmpty(),
    name = this?.name.orEmpty(),
    username = this?.login.orEmpty(),
    email = this?.email.orEmpty(),
    city = this?.location.orEmpty(),
    bio = this?.bio.orEmpty(),
    follower = this?.followers ?: 0
)

fun RepositoriesResponse?.toModel() = RepositoryModel(
    avatar = this?.owner?.avatarUrl.orEmpty(),
    name = this?.name.orEmpty(),
    description = this?.description.orEmpty(),
    stars = this?.stargazersCount ?: 0,
    lastUpdate = this?.updatedAt?.let {
        DateUtils.getRelativeTimeSpanString(convertDateToLong(it)).toString()
    } ?: run { "" }
)


// Database Mapper
fun SearchResponse?.toDb(q: String, page: Int) = SearchEntity(
    id = q+page,
    query = q,
    page = page,
    result = this?.items?.joinToString(separator = AppConstant.SEPARATOR_DB) { it.login.orEmpty() }.orEmpty()
)

fun SearchResponse.UserResponse?.toDb() = UserEntity(
    avatar = this?.avatar_url.orEmpty(),
    username = this?.login.orEmpty()
)

fun UserResponse?.toDb() = UserEntity(
    avatar = this?.avatarUrl.orEmpty(),
    name = this?.name.orEmpty(),
    username = this?.login.orEmpty(),
    email = this?.email.orEmpty(),
    city = this?.location.orEmpty(),
    bio = this?.bio.orEmpty(),
    follower = this?.followers ?: 0
)

fun UserEntity?.toModel() = UserModel(
    avatar = this?.avatar.orEmpty(),
    name = this?.name.orEmpty(),
    username = this?.username.orEmpty(),
    email = this?.email.orEmpty(),
    city = this?.city.orEmpty(),
    bio = this?.bio.orEmpty(),
    follower = this?.follower ?: 0,
)


@SuppressLint("SimpleDateFormat")
private fun convertDateToLong(date: String): Long {
    val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    return df.parse(date).time
}