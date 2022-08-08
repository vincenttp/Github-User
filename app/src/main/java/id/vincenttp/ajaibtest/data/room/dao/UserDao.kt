package id.vincenttp.ajaibtest.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import id.vincenttp.ajaibtest.data.room.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE username IN (:username)")
    fun loadAllByIds(username: String): UserEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(users: UserEntity)

    @Update
    fun update(users: UserEntity)

}