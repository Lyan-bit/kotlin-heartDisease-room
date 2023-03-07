package com.example.heartdisease

import kotlinx.coroutines.flow.Flow

class Repository : HeartDiseaseRepository  {

    private val heartDiseaseDao: HeartDiseaseEntityDao by lazy { HeartDiseaseApplication.database.heartDiseaseDao() }

    val allHeartDiseases: Flow<List<HeartDiseaseEntity>> = heartDiseaseDao.listHeartDiseases()

    val allHeartDiseaseids: Flow<List<String>> = heartDiseaseDao.listHeartDiseaseids()
    val allHeartDiseaseages: Flow<List<Int>> = heartDiseaseDao.listHeartDiseaseages()
    val allHeartDiseasesexs: Flow<List<Int>> = heartDiseaseDao.listHeartDiseasesexs()
    val allHeartDiseasecps: Flow<List<Int>> = heartDiseaseDao.listHeartDiseasecps()
    val allHeartDiseasetrestbpss: Flow<List<Int>> = heartDiseaseDao.listHeartDiseasetrestbpss()
    val allHeartDiseasechols: Flow<List<Int>> = heartDiseaseDao.listHeartDiseasechols()
    val allHeartDiseasefbss: Flow<List<Int>> = heartDiseaseDao.listHeartDiseasefbss()
    val allHeartDiseaserestecgs: Flow<List<Int>> = heartDiseaseDao.listHeartDiseaserestecgs()
    val allHeartDiseasethalachs: Flow<List<Int>> = heartDiseaseDao.listHeartDiseasethalachs()
    val allHeartDiseaseexangs: Flow<List<Int>> = heartDiseaseDao.listHeartDiseaseexangs()
    val allHeartDiseaseoldpeaks: Flow<List<Int>> = heartDiseaseDao.listHeartDiseaseoldpeaks()
    val allHeartDiseaseslopes: Flow<List<Int>> = heartDiseaseDao.listHeartDiseaseslopes()
    val allHeartDiseasecas: Flow<List<Int>> = heartDiseaseDao.listHeartDiseasecas()
    val allHeartDiseasethals: Flow<List<Int>> = heartDiseaseDao.listHeartDiseasethals()
    val allHeartDiseaseoutcomes: Flow<List<String>> = heartDiseaseDao.listHeartDiseaseoutcomes()

    //Create
    override suspend fun createHeartDisease(heartDisease: HeartDiseaseEntity) {
        heartDiseaseDao.createHeartDisease(heartDisease)
    }

    //Read
    override suspend fun listHeartDisease(): List<HeartDiseaseEntity> {
        return heartDiseaseDao.listHeartDisease()
    }

    //Update
    override suspend fun updateHeartDisease(heartDisease: HeartDiseaseEntity) {
        heartDiseaseDao.updateHeartDisease(heartDisease)
    }

    //Delete all HeartDiseases
    override suspend fun deleteHeartDiseases() {
       heartDiseaseDao.deleteHeartDiseases()
    }

    //Delete a HeartDisease
	override suspend fun deleteHeartDisease(id: String) {
	   heartDiseaseDao.deleteHeartDisease(id)
    }
    
     //Search with live data
     override fun searchByHeartDiseaseid (searchQuery: String): Flow<List<HeartDiseaseEntity>>  {
         return heartDiseaseDao.searchByHeartDiseaseid(searchQuery)
     }
     
     //Search with live data
     override fun searchByHeartDiseaseage (searchQuery: Int): Flow<List<HeartDiseaseEntity>>  {
         return heartDiseaseDao.searchByHeartDiseaseage(searchQuery)
     }
     
     //Search with live data
     override fun searchByHeartDiseasesex (searchQuery: Int): Flow<List<HeartDiseaseEntity>>  {
         return heartDiseaseDao.searchByHeartDiseasesex(searchQuery)
     }
     
     //Search with live data
     override fun searchByHeartDiseasecp (searchQuery: Int): Flow<List<HeartDiseaseEntity>>  {
         return heartDiseaseDao.searchByHeartDiseasecp(searchQuery)
     }
     
     //Search with live data
     override fun searchByHeartDiseasetrestbps (searchQuery: Int): Flow<List<HeartDiseaseEntity>>  {
         return heartDiseaseDao.searchByHeartDiseasetrestbps(searchQuery)
     }
     
     //Search with live data
     override fun searchByHeartDiseasechol (searchQuery: Int): Flow<List<HeartDiseaseEntity>>  {
         return heartDiseaseDao.searchByHeartDiseasechol(searchQuery)
     }
     
     //Search with live data
     override fun searchByHeartDiseasefbs (searchQuery: Int): Flow<List<HeartDiseaseEntity>>  {
         return heartDiseaseDao.searchByHeartDiseasefbs(searchQuery)
     }
     
     //Search with live data
     override fun searchByHeartDiseaserestecg (searchQuery: Int): Flow<List<HeartDiseaseEntity>>  {
         return heartDiseaseDao.searchByHeartDiseaserestecg(searchQuery)
     }
     
     //Search with live data
     override fun searchByHeartDiseasethalach (searchQuery: Int): Flow<List<HeartDiseaseEntity>>  {
         return heartDiseaseDao.searchByHeartDiseasethalach(searchQuery)
     }
     
     //Search with live data
     override fun searchByHeartDiseaseexang (searchQuery: Int): Flow<List<HeartDiseaseEntity>>  {
         return heartDiseaseDao.searchByHeartDiseaseexang(searchQuery)
     }
     
     //Search with live data
     override fun searchByHeartDiseaseoldpeak (searchQuery: Int): Flow<List<HeartDiseaseEntity>>  {
         return heartDiseaseDao.searchByHeartDiseaseoldpeak(searchQuery)
     }
     
     //Search with live data
     override fun searchByHeartDiseaseslope (searchQuery: Int): Flow<List<HeartDiseaseEntity>>  {
         return heartDiseaseDao.searchByHeartDiseaseslope(searchQuery)
     }
     
     //Search with live data
     override fun searchByHeartDiseaseca (searchQuery: Int): Flow<List<HeartDiseaseEntity>>  {
         return heartDiseaseDao.searchByHeartDiseaseca(searchQuery)
     }
     
     //Search with live data
     override fun searchByHeartDiseasethal (searchQuery: Int): Flow<List<HeartDiseaseEntity>>  {
         return heartDiseaseDao.searchByHeartDiseasethal(searchQuery)
     }
     
     //Search with live data
     override fun searchByHeartDiseaseoutcome (searchQuery: String): Flow<List<HeartDiseaseEntity>>  {
         return heartDiseaseDao.searchByHeartDiseaseoutcome(searchQuery)
     }
     

    //Search with suspend
     override suspend fun searchByHeartDiseaseid2 (id: String): List<HeartDiseaseEntity> {
          return heartDiseaseDao.searchByHeartDiseaseid2(id)
     }
	     
    //Search with suspend
     override suspend fun searchByHeartDiseaseage2 (age: Int): List<HeartDiseaseEntity> {
          return heartDiseaseDao.searchByHeartDiseaseage2(age)
     }
	     
    //Search with suspend
     override suspend fun searchByHeartDiseasesex2 (sex: Int): List<HeartDiseaseEntity> {
          return heartDiseaseDao.searchByHeartDiseasesex2(sex)
     }
	     
    //Search with suspend
     override suspend fun searchByHeartDiseasecp2 (cp: Int): List<HeartDiseaseEntity> {
          return heartDiseaseDao.searchByHeartDiseasecp2(cp)
     }
	     
    //Search with suspend
     override suspend fun searchByHeartDiseasetrestbps2 (trestbps: Int): List<HeartDiseaseEntity> {
          return heartDiseaseDao.searchByHeartDiseasetrestbps2(trestbps)
     }
	     
    //Search with suspend
     override suspend fun searchByHeartDiseasechol2 (chol: Int): List<HeartDiseaseEntity> {
          return heartDiseaseDao.searchByHeartDiseasechol2(chol)
     }
	     
    //Search with suspend
     override suspend fun searchByHeartDiseasefbs2 (fbs: Int): List<HeartDiseaseEntity> {
          return heartDiseaseDao.searchByHeartDiseasefbs2(fbs)
     }
	     
    //Search with suspend
     override suspend fun searchByHeartDiseaserestecg2 (restecg: Int): List<HeartDiseaseEntity> {
          return heartDiseaseDao.searchByHeartDiseaserestecg2(restecg)
     }
	     
    //Search with suspend
     override suspend fun searchByHeartDiseasethalach2 (thalach: Int): List<HeartDiseaseEntity> {
          return heartDiseaseDao.searchByHeartDiseasethalach2(thalach)
     }
	     
    //Search with suspend
     override suspend fun searchByHeartDiseaseexang2 (exang: Int): List<HeartDiseaseEntity> {
          return heartDiseaseDao.searchByHeartDiseaseexang2(exang)
     }
	     
    //Search with suspend
     override suspend fun searchByHeartDiseaseoldpeak2 (oldpeak: Int): List<HeartDiseaseEntity> {
          return heartDiseaseDao.searchByHeartDiseaseoldpeak2(oldpeak)
     }
	     
    //Search with suspend
     override suspend fun searchByHeartDiseaseslope2 (slope: Int): List<HeartDiseaseEntity> {
          return heartDiseaseDao.searchByHeartDiseaseslope2(slope)
     }
	     
    //Search with suspend
     override suspend fun searchByHeartDiseaseca2 (ca: Int): List<HeartDiseaseEntity> {
          return heartDiseaseDao.searchByHeartDiseaseca2(ca)
     }
	     
    //Search with suspend
     override suspend fun searchByHeartDiseasethal2 (thal: Int): List<HeartDiseaseEntity> {
          return heartDiseaseDao.searchByHeartDiseasethal2(thal)
     }
	     
    //Search with suspend
     override suspend fun searchByHeartDiseaseoutcome2 (outcome: String): List<HeartDiseaseEntity> {
          return heartDiseaseDao.searchByHeartDiseaseoutcome2(outcome)
     }
	     


}
