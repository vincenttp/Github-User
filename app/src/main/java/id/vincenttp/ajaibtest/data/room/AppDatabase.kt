package id.vincenttp.ajaibtest.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.vincenttp.ajaibtest.data.room.dao.SearchDao
import id.vincenttp.ajaibtest.data.room.dao.UserDao
import id.vincenttp.ajaibtest.data.room.entity.SearchEntity
import id.vincenttp.ajaibtest.data.room.entity.UserEntity

@Database(
    entities = [
        UserEntity::class,
        SearchEntity::class
    ], version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun searchDao(): SearchDao

    companion object {
        fun getDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java, "database"
            ).build()
        }

    }
}