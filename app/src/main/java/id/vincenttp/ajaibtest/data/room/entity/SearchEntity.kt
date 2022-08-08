package id.vincenttp.ajaibtest.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "search")
data class SearchEntity(
    @PrimaryKey val id: String,
    val query: String,
    val page: Int,
    val result: String
)
