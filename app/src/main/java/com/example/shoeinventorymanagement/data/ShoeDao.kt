package com.example.shoeinventorymanagement.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoeDao {

    @Query("SELECT * FROM shoe_table ORDER BY brand ASC")
//    fun getAllShoes() : Flow<MutableList<Shoe>>
    fun getAllShoes() : Flow<List<Shoe>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(shoe: Shoe)

    @Query("DELETE FROM shoe_table")
    suspend fun deleteAll()

}