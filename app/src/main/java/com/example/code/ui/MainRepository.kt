package com.example.code.ui

import androidx.lifecycle.MutableLiveData
import com.example.code.root.RootRepository
import javax.inject.Inject

interface MainRepository : RootRepository {
    fun getData():MutableLiveData<List<String>>
}


class MainRepositoryImpl @Inject constructor() : MainRepository {

    override fun getData(): MutableLiveData<List<String>> {
       return MutableLiveData()
    }

}