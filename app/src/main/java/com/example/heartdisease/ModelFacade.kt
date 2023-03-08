package com.example.heartdisease

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.ArrayList
import android.content.res.AssetManager
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.channels.FileChannel
import java.util.*

class ModelFacade private constructor(context: Context) {

    private val assetManager: AssetManager = context.assets
    private var fileSystem: FileAccessor



    init {
    	//init
        fileSystem = FileAccessor(context)
    }

    companion object {
    	private val repository by lazy { Repository() }
        private var instance: ModelFacade? = null
        fun getInstance(context: Context): ModelFacade {
            return instance ?: ModelFacade(context)
        }
    }
    

    val allHeartDiseases: LiveData<List<HeartDiseaseEntity>> = repository.allHeartDiseases.asLiveData()

    val allHeartDiseaseIds: LiveData<List<String>> = repository.allHeartDiseaseids.asLiveData()
    val allHeartDiseaseAges: LiveData<List<Int>> = repository.allHeartDiseaseages.asLiveData()
    val allHeartDiseaseSexs: LiveData<List<Int>> = repository.allHeartDiseasesexs.asLiveData()
    val allHeartDiseaseCps: LiveData<List<Int>> = repository.allHeartDiseasecps.asLiveData()
    val allHeartDiseaseTrestbpss: LiveData<List<Int>> = repository.allHeartDiseasetrestbpss.asLiveData()
    val allHeartDiseaseChols: LiveData<List<Int>> = repository.allHeartDiseasechols.asLiveData()
    val allHeartDiseaseFbss: LiveData<List<Int>> = repository.allHeartDiseasefbss.asLiveData()
    val allHeartDiseaseRestecgs: LiveData<List<Int>> = repository.allHeartDiseaserestecgs.asLiveData()
    val allHeartDiseaseThalachs: LiveData<List<Int>> = repository.allHeartDiseasethalachs.asLiveData()
    val allHeartDiseaseExangs: LiveData<List<Int>> = repository.allHeartDiseaseexangs.asLiveData()
    val allHeartDiseaseOldpeaks: LiveData<List<Int>> = repository.allHeartDiseaseoldpeaks.asLiveData()
    val allHeartDiseaseSlopes: LiveData<List<Int>> = repository.allHeartDiseaseslopes.asLiveData()
    val allHeartDiseaseCas: LiveData<List<Int>> = repository.allHeartDiseasecas.asLiveData()
    val allHeartDiseaseThals: LiveData<List<Int>> = repository.allHeartDiseasethals.asLiveData()
    val allHeartDiseaseOutcomes: LiveData<List<String>> = repository.allHeartDiseaseoutcomes.asLiveData()
    private var currentHeartDisease: HeartDiseaseEntity? = null
    private var currentHeartDiseases: List<HeartDiseaseEntity> = ArrayList()
	    
    fun searchByHeartDiseaseid(searchQuery: String): LiveData<List<HeartDiseaseEntity>>  {
        return repository.searchByHeartDiseaseid(searchQuery).asLiveData()
    }
    
    fun searchByHeartDiseaseage(searchQuery: Int): LiveData<List<HeartDiseaseEntity>>  {
        return repository.searchByHeartDiseaseage(searchQuery).asLiveData()
    }
    
    fun searchByHeartDiseasesex(searchQuery: Int): LiveData<List<HeartDiseaseEntity>>  {
        return repository.searchByHeartDiseasesex(searchQuery).asLiveData()
    }
    
    fun searchByHeartDiseasecp(searchQuery: Int): LiveData<List<HeartDiseaseEntity>>  {
        return repository.searchByHeartDiseasecp(searchQuery).asLiveData()
    }
    
    fun searchByHeartDiseasetrestbps(searchQuery: Int): LiveData<List<HeartDiseaseEntity>>  {
        return repository.searchByHeartDiseasetrestbps(searchQuery).asLiveData()
    }
    
    fun searchByHeartDiseasechol(searchQuery: Int): LiveData<List<HeartDiseaseEntity>>  {
        return repository.searchByHeartDiseasechol(searchQuery).asLiveData()
    }
    
    fun searchByHeartDiseasefbs(searchQuery: Int): LiveData<List<HeartDiseaseEntity>>  {
        return repository.searchByHeartDiseasefbs(searchQuery).asLiveData()
    }
    
    fun searchByHeartDiseaserestecg(searchQuery: Int): LiveData<List<HeartDiseaseEntity>>  {
        return repository.searchByHeartDiseaserestecg(searchQuery).asLiveData()
    }
    
    fun searchByHeartDiseasethalach(searchQuery: Int): LiveData<List<HeartDiseaseEntity>>  {
        return repository.searchByHeartDiseasethalach(searchQuery).asLiveData()
    }
    
    fun searchByHeartDiseaseexang(searchQuery: Int): LiveData<List<HeartDiseaseEntity>>  {
        return repository.searchByHeartDiseaseexang(searchQuery).asLiveData()
    }
    
    fun searchByHeartDiseaseoldpeak(searchQuery: Int): LiveData<List<HeartDiseaseEntity>>  {
        return repository.searchByHeartDiseaseoldpeak(searchQuery).asLiveData()
    }
    
    fun searchByHeartDiseaseslope(searchQuery: Int): LiveData<List<HeartDiseaseEntity>>  {
        return repository.searchByHeartDiseaseslope(searchQuery).asLiveData()
    }
    
    fun searchByHeartDiseaseca(searchQuery: Int): LiveData<List<HeartDiseaseEntity>>  {
        return repository.searchByHeartDiseaseca(searchQuery).asLiveData()
    }
    
    fun searchByHeartDiseasethal(searchQuery: Int): LiveData<List<HeartDiseaseEntity>>  {
        return repository.searchByHeartDiseasethal(searchQuery).asLiveData()
    }
    
    fun searchByHeartDiseaseoutcome(searchQuery: String): LiveData<List<HeartDiseaseEntity>>  {
        return repository.searchByHeartDiseaseoutcome(searchQuery).asLiveData()
    }
    

	fun getHeartDiseaseByPK(value: String): Flow<HeartDisease> {
        val res: Flow<List<HeartDiseaseEntity>> = repository.searchByHeartDiseaseid(value)
        return res.map { heartDisease ->
            val itemx = HeartDisease.createByPKHeartDisease(value)
            if (heartDisease.isNotEmpty()) {
            itemx.id = heartDisease[0].id
            }
            if (heartDisease.isNotEmpty()) {
            itemx.age = heartDisease[0].age
            }
            if (heartDisease.isNotEmpty()) {
            itemx.sex = heartDisease[0].sex
            }
            if (heartDisease.isNotEmpty()) {
            itemx.cp = heartDisease[0].cp
            }
            if (heartDisease.isNotEmpty()) {
            itemx.trestbps = heartDisease[0].trestbps
            }
            if (heartDisease.isNotEmpty()) {
            itemx.chol = heartDisease[0].chol
            }
            if (heartDisease.isNotEmpty()) {
            itemx.fbs = heartDisease[0].fbs
            }
            if (heartDisease.isNotEmpty()) {
            itemx.restecg = heartDisease[0].restecg
            }
            if (heartDisease.isNotEmpty()) {
            itemx.thalach = heartDisease[0].thalach
            }
            if (heartDisease.isNotEmpty()) {
            itemx.exang = heartDisease[0].exang
            }
            if (heartDisease.isNotEmpty()) {
            itemx.oldpeak = heartDisease[0].oldpeak
            }
            if (heartDisease.isNotEmpty()) {
            itemx.slope = heartDisease[0].slope
            }
            if (heartDisease.isNotEmpty()) {
            itemx.ca = heartDisease[0].ca
            }
            if (heartDisease.isNotEmpty()) {
            itemx.thal = heartDisease[0].thal
            }
            if (heartDisease.isNotEmpty()) {
            itemx.outcome = heartDisease[0].outcome
            }
            itemx
        }
    }
    
	  suspend fun createHeartDisease(x: HeartDiseaseEntity) {
	    repository.createHeartDisease(x)
	    currentHeartDisease = x
	}
    
    suspend fun editHeartDisease(x: HeartDiseaseEntity) {
		 repository.updateHeartDisease(x)
         currentHeartDisease = x
    }
		    
   fun setSelectedHeartDisease(x: HeartDiseaseEntity) {
		 currentHeartDisease = x
	}
		    
    suspend fun deleteHeartDisease(id: String) {
  		  repository.deleteHeartDisease(id)
  		  currentHeartDisease = null
  	}
  				
      suspend fun searchHeartDiseaseByAge(age: Int) : ArrayList<HeartDisease> {
				currentHeartDiseases = repository.searchByHeartDiseaseage2(age)
				var itemsList = ArrayList<HeartDisease>()
				for (x in currentHeartDiseases.indices) {
					val vo: HeartDiseaseEntity = currentHeartDiseases[x]
				    val itemx = HeartDisease.createByPKHeartDisease(vo.id)
					    itemx.id = vo.id
					    itemx.age = vo.age
					    itemx.sex = vo.sex
					    itemx.cp = vo.cp
					    itemx.trestbps = vo.trestbps
					    itemx.chol = vo.chol
					    itemx.fbs = vo.fbs
					    itemx.restecg = vo.restecg
					    itemx.thalach = vo.thalach
					    itemx.exang = vo.exang
					    itemx.oldpeak = vo.oldpeak
					    itemx.slope = vo.slope
					    itemx.ca = vo.ca
					    itemx.thal = vo.thal
					    itemx.outcome = vo.outcome
				itemsList.add(itemx)
			}
		return itemsList
		}

		
    suspend fun classifyHeartDisease(heartDisease: HeartDisease) : String {
        var result = ""
	    lateinit var tflite : Interpreter
	    lateinit var tflitemodel : ByteBuffer
	
	    try{
	        tflitemodel = loadModelFile(assetManager, "heartDisease.tflite")
	        tflite = Interpreter(tflitemodel) 
	       } catch(ex: Exception){
	            ex.printStackTrace()
	    }
	        
	    val inputVal: FloatArray = floatArrayOf(
	            ((heartDisease.age - 29) / (77 - 29)).toFloat(),
	            (heartDisease.sex).toFloat(),
	            ((heartDisease.cp - 0) / (3 - 0)).toFloat(),
	            ((heartDisease.trestbps - 94) / (200 - 94)).toFloat(),
	            ((heartDisease.chol - 126) / (564 - 126)).toFloat(),
	            (heartDisease.fbs).toFloat(),
	            ((heartDisease.restecg - 0) / (2 - 0)).toFloat(),
	            ((heartDisease.thalach - 71) / (202 - 71)).toFloat(),
	            (heartDisease.exang).toFloat(),
	            ((heartDisease.oldpeak - 0) / (6.2 - 0)).toFloat(),
	            ((heartDisease.slope - 0) / (2 - 0)).toFloat(),
	            ((heartDisease.ca - 0) / (4 - 0)).toFloat(),
	            ((heartDisease.thal - 0) / (3 - 0)).toFloat()
	        )
	    val outputVal: ByteBuffer = ByteBuffer.allocateDirect(8)
	    outputVal.order(ByteOrder.nativeOrder())
	    tflite.run(inputVal, outputVal)
	    outputVal.rewind()
	        
	  	val labelsList : List<String> = listOf ("positive","negative")
	    val output = FloatArray(2)
	        for (i in 0..1) {
	            output[i] = outputVal.float
	        }
	        
	     result = getSortedResult(output, labelsList).get(0).toString()
	        
	        heartDisease.outcome = result
	        persistHeartDisease(heartDisease)
	        
	     return result
	    }
	    
	    data class Recognition(
	            var id: String = "",
	            var title: String = "",
	            var confidence: Float = 0F
	        )  {
	            override fun toString(): String {
	                return "$title ($confidence%)"
	            }
	        }
	    
	private fun getSortedResult(labelProbArray: FloatArray, labelList: List<String>): List<Recognition> {
	    
	    val pq = PriorityQueue(
	        labelList.size,
	        Comparator<Recognition> {
	              (_, _, confidence1), (_, _, confidence2)
	              -> confidence1.compareTo(confidence2) * -1
	        })
	    
	    for (i in labelList.indices) {
	        val confidence = labelProbArray[i]
	        pq.add(
	        Recognition("" + i,
	         	if (labelList.size > i) labelList[i] else "Unknown", confidence*100))
	    }
	    val recognitions = ArrayList<Recognition>()
	    val recognitionsSize = Math.min(pq.size, labelList.size)
	    
	    if (pq.size != 0) {
	       for (i in 0 until recognitionsSize) {
	           recognitions.add(pq.poll())
	       }
	    }
	    else {
	           recognitions.add(Recognition("0", "Unknown",100F))
	         }
	    return recognitions
	}
	        
	private fun loadModelFile(assetManager: AssetManager, modelPath: String): ByteBuffer {
	        val fileDescriptor = assetManager.openFd(modelPath)
	        val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
	        val fileChannel = inputStream.channel
	        val startOffset = fileDescriptor.startOffset
	        val declaredLength = fileDescriptor.declaredLength
	        return fileChannel.map(
	            FileChannel.MapMode.READ_ONLY,
	            startOffset, declaredLength)
	}

    suspend fun listHeartDisease(): List<HeartDiseaseEntity> {
	        currentHeartDiseases = repository.listHeartDisease()
	        return currentHeartDiseases
	    }	
	  
	suspend fun listAllHeartDisease(): ArrayList<HeartDisease> {	
		currentHeartDiseases = repository.listHeartDisease()
		var res = ArrayList<HeartDisease>()
			for (x in currentHeartDiseases.indices) {
					val vo: HeartDiseaseEntity = currentHeartDiseases[x]
				    val itemx = HeartDisease.createByPKHeartDisease(vo.id)
	            itemx.id = vo.id
            itemx.age = vo.age
            itemx.sex = vo.sex
            itemx.cp = vo.cp
            itemx.trestbps = vo.trestbps
            itemx.chol = vo.chol
            itemx.fbs = vo.fbs
            itemx.restecg = vo.restecg
            itemx.thalach = vo.thalach
            itemx.exang = vo.exang
            itemx.oldpeak = vo.oldpeak
            itemx.slope = vo.slope
            itemx.ca = vo.ca
            itemx.thal = vo.thal
            itemx.outcome = vo.outcome
			res.add(itemx)
		}
		return res
	}

    suspend fun stringListHeartDisease(): List<String> {
        currentHeartDiseases = repository.listHeartDisease()
        val res: ArrayList<String> = ArrayList()
        for (x in currentHeartDiseases.indices) {
            res.add(currentHeartDiseases[x].toString())
        }
        return res
    }

    suspend fun getHeartDiseaseByPK2(value: String): HeartDisease? {
        val res: List<HeartDiseaseEntity> = repository.searchByHeartDiseaseid2(value)
	        return if (res.isEmpty()) {
	            null
	        } else {
	            val vo: HeartDiseaseEntity = res[0]
	            val itemx = HeartDisease.createByPKHeartDisease(value)
	            itemx.id = vo.id
            itemx.age = vo.age
            itemx.sex = vo.sex
            itemx.cp = vo.cp
            itemx.trestbps = vo.trestbps
            itemx.chol = vo.chol
            itemx.fbs = vo.fbs
            itemx.restecg = vo.restecg
            itemx.thalach = vo.thalach
            itemx.exang = vo.exang
            itemx.oldpeak = vo.oldpeak
            itemx.slope = vo.slope
            itemx.ca = vo.ca
            itemx.thal = vo.thal
            itemx.outcome = vo.outcome
	            itemx
	        }
    }
    
    suspend fun retrieveHeartDisease(value: String): HeartDisease? {
            return getHeartDiseaseByPK2(value)
    }

    suspend fun allHeartDiseaseIds(): ArrayList<String> {
        currentHeartDiseases = repository.listHeartDisease()
        val res: ArrayList<String> = ArrayList()
            for (heartdisease in currentHeartDiseases.indices) {
                res.add(currentHeartDiseases[heartdisease].id)
            }
        return res
    }

    fun setSelectedHeartDisease(i: Int) {
        if (i < currentHeartDiseases.size) {
            currentHeartDisease = currentHeartDiseases[i]
        }
    }

    fun getSelectedHeartDisease(): HeartDiseaseEntity? {
        return currentHeartDisease
    }

    suspend fun persistHeartDisease(x: HeartDisease) {
        val vo = HeartDiseaseEntity(x.id, x.age, x.sex, x.cp, x.trestbps, x.chol, x.fbs, x.restecg, x.thalach, x.exang, x.oldpeak, x.slope, x.ca, x.thal, x.outcome)
        repository.updateHeartDisease(vo)
        currentHeartDisease = vo
    }
	

	
}
