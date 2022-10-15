package com.example.a1hw4monthlifetracker

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.a1hw4monthlifetracker.room.AppDataBase

class App: Application() {

    companion object{
    lateinit var appDataDataBase: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        appDataDataBase = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java, "database-name"
        ).allowMainThreadQueries().build()
    }
}