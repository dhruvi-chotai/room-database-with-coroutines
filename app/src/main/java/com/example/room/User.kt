package com.example.room


import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val surname: String,
    val profession: String
)