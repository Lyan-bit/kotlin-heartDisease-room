package com.example.heartdisease

import kotlinx.coroutines.flow.Flow

interface HeartDiseaseRepository {
    //Read
    suspend fun listHeartDisease(): List<HeartDiseaseEntity>

    //Create
    suspend fun createHeartDisease(heartDisease: HeartDiseaseEntity)

    //Update
    suspend fun updateHeartDisease(heartDisease: HeartDiseaseEntity)

    //Delete All HeartDiseases
    suspend fun deleteHeartDiseases()


    //Delete a HeartDisease by PK
	suspend fun deleteHeartDisease(id: String)
	    
    //Search with live data
    fun searchByHeartDiseaseid(searchQuery: String): Flow<List<HeartDiseaseEntity>>
    //Search with live data
    fun searchByHeartDiseaseage(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
    //Search with live data
    fun searchByHeartDiseasesex(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
    //Search with live data
    fun searchByHeartDiseasecp(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
    //Search with live data
    fun searchByHeartDiseasetrestbps(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
    //Search with live data
    fun searchByHeartDiseasechol(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
    //Search with live data
    fun searchByHeartDiseasefbs(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
    //Search with live data
    fun searchByHeartDiseaserestecg(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
    //Search with live data
    fun searchByHeartDiseasethalach(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
    //Search with live data
    fun searchByHeartDiseaseexang(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
    //Search with live data
    fun searchByHeartDiseaseoldpeak(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
    //Search with live data
    fun searchByHeartDiseaseslope(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
    //Search with live data
    fun searchByHeartDiseaseca(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
    //Search with live data
    fun searchByHeartDiseasethal(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
    //Search with live data
    fun searchByHeartDiseaseoutcome(searchQuery: String): Flow<List<HeartDiseaseEntity>>

    //Search with suspend
    suspend fun searchByHeartDiseaseid2(searchQuery: String): List<HeartDiseaseEntity>
    suspend fun searchByHeartDiseaseage2(searchQuery: Int): List<HeartDiseaseEntity>
    suspend fun searchByHeartDiseasesex2(searchQuery: Int): List<HeartDiseaseEntity>
    suspend fun searchByHeartDiseasecp2(searchQuery: Int): List<HeartDiseaseEntity>
    suspend fun searchByHeartDiseasetrestbps2(searchQuery: Int): List<HeartDiseaseEntity>
    suspend fun searchByHeartDiseasechol2(searchQuery: Int): List<HeartDiseaseEntity>
    suspend fun searchByHeartDiseasefbs2(searchQuery: Int): List<HeartDiseaseEntity>
    suspend fun searchByHeartDiseaserestecg2(searchQuery: Int): List<HeartDiseaseEntity>
    suspend fun searchByHeartDiseasethalach2(searchQuery: Int): List<HeartDiseaseEntity>
    suspend fun searchByHeartDiseaseexang2(searchQuery: Int): List<HeartDiseaseEntity>
    suspend fun searchByHeartDiseaseoldpeak2(searchQuery: Int): List<HeartDiseaseEntity>
    suspend fun searchByHeartDiseaseslope2(searchQuery: Int): List<HeartDiseaseEntity>
    suspend fun searchByHeartDiseaseca2(searchQuery: Int): List<HeartDiseaseEntity>
    suspend fun searchByHeartDiseasethal2(searchQuery: Int): List<HeartDiseaseEntity>
    suspend fun searchByHeartDiseaseoutcome2(searchQuery: String): List<HeartDiseaseEntity>

}
