package com.example.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FunFactDao {

    @Query("SELECT * FROM fun_fact_table ORDER BY id ASC")
    fun getFunFactEntity(): List<FunFactEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(funFact: FunFactEntity)

    @Query("DELETE FROM fun_fact_table")
    suspend fun deleteAll()
}