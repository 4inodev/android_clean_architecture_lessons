package com.example.testapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.SaveUserNameParam
import com.example.domain.usecases.GetUserNameUseCase
import com.example.domain.usecases.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val resultLiveDataMutable = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = resultLiveDataMutable

    init {
        Log.d("AAA", "VM created")
    }

    override fun onCleared() {
        Log.d("AAA", "VM cleared")
        super.onCleared()
    }

    fun save(text: String) {
        val param = SaveUserNameParam(name = text)
        val resultData = saveUserNameUseCase.execute(param = param)
        resultLiveDataMutable.value = "Save result = $resultData"
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        resultLiveDataMutable.value = "${userName.firstName} ${userName.lastName}"
    }
}