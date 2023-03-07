package com.example.heartdisease

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heartDiseaseTable")
data class HeartDiseaseEntity (
    @PrimaryKey
    val id: String, 
    val age: Int, 
    val sex: Int, 
    val cp: Int, 
    val trestbps: Int, 
    val chol: Int, 
    val fbs: Int, 
    val restecg: Int, 
    val thalach: Int, 
    val exang: Int, 
    val oldpeak: Int, 
    val slope: Int, 
    val ca: Int, 
    val thal: Int, 
    val outcome: String
)
