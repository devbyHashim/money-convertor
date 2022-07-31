package com.example.code.ui

import androidx.arch.core.util.Function
import androidx.lifecycle.*

class MainViewModel(private val savedStateHandle: SavedStateHandle,private val mainRepository: MainRepository) : ViewModel() {
    val id = MutableLiveData<String>().apply {
        value = "1"
    }
    val data = Transformations.switchMap(id,object : Function<String,LiveData<List<String>>>{
        override fun apply(input: String?): LiveData<List<String>>? {
            if (input.isNullOrBlank()){
                return null
            }
            return mainRepository.getData()

        }

    })

}