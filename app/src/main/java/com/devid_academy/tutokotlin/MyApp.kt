package com.devid_academy.tutokotlin

import android.app.Application
import androidx.room.Room

class MyApp : Application(){
    companion object {
        lateinit var db: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(this, AppDatabase::class.java, "formation_db")
            .build()
    }


}