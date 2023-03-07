package com.example.heartdisease

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface HeartDiseaseEntityDao {
    //LiveData
    //Read (list entity)
    @Query("SELECT * FROM heartDiseaseTable")
    fun listHeartDiseases(): Flow<List<HeartDiseaseEntity>>

    //Read (list id)
	@Query("SELECT id FROM heartDiseaseTable")
	fun listHeartDiseaseids (): Flow<List<String>>
    //Read (list age)
	@Query("SELECT age FROM heartDiseaseTable")
	fun listHeartDiseaseages (): Flow<List<Int>>
    //Read (list sex)
	@Query("SELECT sex FROM heartDiseaseTable")
	fun listHeartDiseasesexs (): Flow<List<Int>>
    //Read (list cp)
	@Query("SELECT cp FROM heartDiseaseTable")
	fun listHeartDiseasecps (): Flow<List<Int>>
    //Read (list trestbps)
	@Query("SELECT trestbps FROM heartDiseaseTable")
	fun listHeartDiseasetrestbpss (): Flow<List<Int>>
    //Read (list chol)
	@Query("SELECT chol FROM heartDiseaseTable")
	fun listHeartDiseasechols (): Flow<List<Int>>
    //Read (list fbs)
	@Query("SELECT fbs FROM heartDiseaseTable")
	fun listHeartDiseasefbss (): Flow<List<Int>>
    //Read (list restecg)
	@Query("SELECT restecg FROM heartDiseaseTable")
	fun listHeartDiseaserestecgs (): Flow<List<Int>>
    //Read (list thalach)
	@Query("SELECT thalach FROM heartDiseaseTable")
	fun listHeartDiseasethalachs (): Flow<List<Int>>
    //Read (list exang)
	@Query("SELECT exang FROM heartDiseaseTable")
	fun listHeartDiseaseexangs (): Flow<List<Int>>
    //Read (list oldpeak)
	@Query("SELECT oldpeak FROM heartDiseaseTable")
	fun listHeartDiseaseoldpeaks (): Flow<List<Int>>
    //Read (list slope)
	@Query("SELECT slope FROM heartDiseaseTable")
	fun listHeartDiseaseslopes (): Flow<List<Int>>
    //Read (list ca)
	@Query("SELECT ca FROM heartDiseaseTable")
	fun listHeartDiseasecas (): Flow<List<Int>>
    //Read (list thal)
	@Query("SELECT thal FROM heartDiseaseTable")
	fun listHeartDiseasethals (): Flow<List<Int>>
    //Read (list outcome)
	@Query("SELECT outcome FROM heartDiseaseTable")
	fun listHeartDiseaseoutcomes (): Flow<List<String>>

	//Suspend
    //Create
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun createHeartDisease (heartDisease: HeartDiseaseEntity)

    //Read (list entity with suspend)
    @Query("SELECT * FROM heartDiseaseTable")
    suspend fun listHeartDisease(): List<HeartDiseaseEntity>

    //Update
    @Update
    suspend fun updateHeartDisease (heartDisease: HeartDiseaseEntity)

    //Delete all records
    @Query("DELETE FROM heartDiseaseTable")
    suspend fun deleteHeartDiseases ()

    //Delete a single record by PK
    @Query("DELETE FROM heartDiseaseTable WHERE id = :id")
    suspend fun deleteHeartDisease (id: String)
    
    //Search with live data
	@Query("SELECT * FROM  heartDiseaseTable WHERE id LIKE :searchQuery ")
	fun searchByHeartDiseaseid(searchQuery: String): Flow<List<HeartDiseaseEntity>>
	@Query("SELECT * FROM  heartDiseaseTable WHERE age LIKE :searchQuery ")
	fun searchByHeartDiseaseage(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
	@Query("SELECT * FROM  heartDiseaseTable WHERE sex LIKE :searchQuery ")
	fun searchByHeartDiseasesex(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
	@Query("SELECT * FROM  heartDiseaseTable WHERE cp LIKE :searchQuery ")
	fun searchByHeartDiseasecp(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
	@Query("SELECT * FROM  heartDiseaseTable WHERE trestbps LIKE :searchQuery ")
	fun searchByHeartDiseasetrestbps(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
	@Query("SELECT * FROM  heartDiseaseTable WHERE chol LIKE :searchQuery ")
	fun searchByHeartDiseasechol(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
	@Query("SELECT * FROM  heartDiseaseTable WHERE fbs LIKE :searchQuery ")
	fun searchByHeartDiseasefbs(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
	@Query("SELECT * FROM  heartDiseaseTable WHERE restecg LIKE :searchQuery ")
	fun searchByHeartDiseaserestecg(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
	@Query("SELECT * FROM  heartDiseaseTable WHERE thalach LIKE :searchQuery ")
	fun searchByHeartDiseasethalach(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
	@Query("SELECT * FROM  heartDiseaseTable WHERE exang LIKE :searchQuery ")
	fun searchByHeartDiseaseexang(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
	@Query("SELECT * FROM  heartDiseaseTable WHERE oldpeak LIKE :searchQuery ")
	fun searchByHeartDiseaseoldpeak(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
	@Query("SELECT * FROM  heartDiseaseTable WHERE slope LIKE :searchQuery ")
	fun searchByHeartDiseaseslope(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
	@Query("SELECT * FROM  heartDiseaseTable WHERE ca LIKE :searchQuery ")
	fun searchByHeartDiseaseca(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
	@Query("SELECT * FROM  heartDiseaseTable WHERE thal LIKE :searchQuery ")
	fun searchByHeartDiseasethal(searchQuery: Int): Flow<List<HeartDiseaseEntity>>
	@Query("SELECT * FROM  heartDiseaseTable WHERE outcome LIKE :searchQuery ")
	fun searchByHeartDiseaseoutcome(searchQuery: String): Flow<List<HeartDiseaseEntity>>

    //Search with suspend
    @Query("SELECT * FROM  heartDiseaseTable WHERE id LIKE :searchQuery")
	suspend fun searchByHeartDiseaseid2(searchQuery: String): List<HeartDiseaseEntity>
    @Query("SELECT * FROM  heartDiseaseTable WHERE age LIKE :searchQuery")
	suspend fun searchByHeartDiseaseage2(searchQuery: Int): List<HeartDiseaseEntity>
    @Query("SELECT * FROM  heartDiseaseTable WHERE sex LIKE :searchQuery")
	suspend fun searchByHeartDiseasesex2(searchQuery: Int): List<HeartDiseaseEntity>
    @Query("SELECT * FROM  heartDiseaseTable WHERE cp LIKE :searchQuery")
	suspend fun searchByHeartDiseasecp2(searchQuery: Int): List<HeartDiseaseEntity>
    @Query("SELECT * FROM  heartDiseaseTable WHERE trestbps LIKE :searchQuery")
	suspend fun searchByHeartDiseasetrestbps2(searchQuery: Int): List<HeartDiseaseEntity>
    @Query("SELECT * FROM  heartDiseaseTable WHERE chol LIKE :searchQuery")
	suspend fun searchByHeartDiseasechol2(searchQuery: Int): List<HeartDiseaseEntity>
    @Query("SELECT * FROM  heartDiseaseTable WHERE fbs LIKE :searchQuery")
	suspend fun searchByHeartDiseasefbs2(searchQuery: Int): List<HeartDiseaseEntity>
    @Query("SELECT * FROM  heartDiseaseTable WHERE restecg LIKE :searchQuery")
	suspend fun searchByHeartDiseaserestecg2(searchQuery: Int): List<HeartDiseaseEntity>
    @Query("SELECT * FROM  heartDiseaseTable WHERE thalach LIKE :searchQuery")
	suspend fun searchByHeartDiseasethalach2(searchQuery: Int): List<HeartDiseaseEntity>
    @Query("SELECT * FROM  heartDiseaseTable WHERE exang LIKE :searchQuery")
	suspend fun searchByHeartDiseaseexang2(searchQuery: Int): List<HeartDiseaseEntity>
    @Query("SELECT * FROM  heartDiseaseTable WHERE oldpeak LIKE :searchQuery")
	suspend fun searchByHeartDiseaseoldpeak2(searchQuery: Int): List<HeartDiseaseEntity>
    @Query("SELECT * FROM  heartDiseaseTable WHERE slope LIKE :searchQuery")
	suspend fun searchByHeartDiseaseslope2(searchQuery: Int): List<HeartDiseaseEntity>
    @Query("SELECT * FROM  heartDiseaseTable WHERE ca LIKE :searchQuery")
	suspend fun searchByHeartDiseaseca2(searchQuery: Int): List<HeartDiseaseEntity>
    @Query("SELECT * FROM  heartDiseaseTable WHERE thal LIKE :searchQuery")
	suspend fun searchByHeartDiseasethal2(searchQuery: Int): List<HeartDiseaseEntity>
    @Query("SELECT * FROM  heartDiseaseTable WHERE outcome LIKE :searchQuery")
	suspend fun searchByHeartDiseaseoutcome2(searchQuery: String): List<HeartDiseaseEntity>

}
