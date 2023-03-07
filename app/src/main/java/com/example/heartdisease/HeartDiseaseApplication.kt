package com.example.heartdisease

import android.app.Application
import androidx.room.Room

class HeartDiseaseApplication : Application() {

    companion object {
        lateinit var database: HeartDiseaseDatabase
            private set
    }
    override fun onCreate() {
        super.onCreate()
        database = Room
            .databaseBuilder(
                this,
                HeartDiseaseDatabase::class.java,
                "heartDiseaseDatabase"
            )
            .build() }
}
