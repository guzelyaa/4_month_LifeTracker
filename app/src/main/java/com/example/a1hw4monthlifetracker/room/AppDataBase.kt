package com.example.a1hw4monthlifetracker.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
   abstract fun taskDao(): TaskDao
}