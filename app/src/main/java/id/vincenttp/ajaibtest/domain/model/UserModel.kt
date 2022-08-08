package id.vincenttp.ajaibtest.domain.model

import java.io.Serializable

data class UserModel(
    val avatar: String,
    var name: String = "",
    val username: String = "",
    var email: String = "",
    var city: String = "",
    var bio: String = "",
    var follower: Int = 0
) : Serializable
