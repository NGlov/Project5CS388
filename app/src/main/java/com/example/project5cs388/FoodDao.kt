package com.example.project5cs388

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {
    @Query("SELECT * FROM food_table")
    fun getAll(): Flow<List<FoodItem>>

    @Insert
    suspend fun insert(foodItem: FoodItem)

    @Query("DELETE FROM food_table")
    suspend fun deleteAll()
}
