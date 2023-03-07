package com.example.heartdisease

import android.content.Context
import java.util.*

class ClassifyHeartDiseaseBean(c: Context) {
    private var model: ModelFacade = ModelFacade.getInstance(c)

    private var heartdisease = ""
	private var instanceHeartDisease: HeartDisease? = null
	

    private var errors = ArrayList<String>()

    fun setHeartDisease(heartdiseasex: String) {
        heartdisease = heartdiseasex
    }
    

    fun resetData() {
        heartdisease = ""
    }

suspend fun isClassifyHeartDiseaseError(): Boolean {
	    errors.clear()
        instanceHeartDisease = model.getHeartDiseaseByPK2(heartdisease)
        if (instanceHeartDisease == null) {
            errors.add("heartDisease must be a valid HeartDisease id")
        }
        

	    return errors.size > 0
	}

    fun errors(): String {
        return errors.toString()
    }

    suspend fun classifyHeartDisease (): String {
        return model.classifyHeartDisease(instanceHeartDisease!!)
    }

}
