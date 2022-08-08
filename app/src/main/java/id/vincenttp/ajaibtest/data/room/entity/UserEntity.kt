package id.vincenttp.ajaibtest.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val username: String = "",
    val avatar: String,
    var name: String = "",
    var email: String = "",
    var city: String = "",
    var bio: String = "",
    var follower: Int = 0
)
