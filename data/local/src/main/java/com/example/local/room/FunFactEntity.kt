package com.example.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fun_fact_table")
class FunFactEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "word") val funFact: String
) {
    fun mapToDomain(): String =
        this.funFact
}