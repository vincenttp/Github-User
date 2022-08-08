package id.vincenttp.ajaibtest.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.vincenttp.ajaibtest.data.room.entity.SearchEntity

@Dao
interface SearchDao {

    @Query("SELECT * FROM search WHERE id IN (:id)")
    fun loadAllByIds(id: String): SearchEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: SearchEntity)
}