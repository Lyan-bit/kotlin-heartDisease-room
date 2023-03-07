package com.example.heartdisease

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [(HeartDiseaseEntity::class)], version = 1, exportSchema = false)
abstract class HeartDiseaseDatabase : RoomDatabase() {
    abstract fun heartDiseaseDao(): HeartDiseaseEntityDao
}
