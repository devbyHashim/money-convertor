package com.example.code.ui

import androidx.lifecycle.SavedStateHandle
import com.example.code.di.ViewModelInjector
import com.example.code.ui.MainViewModel
import javax.inject.Inject

class MainViewModelInjector @Inject constructor(private val mainRepository: MainRepositoryImpl): ViewModelInjector<MainViewModel> {


    override fun create( savedStateHandle: SavedStateHandle): MainViewModel {
        return MainViewModel(savedStateHandle,mainRepository)
    }
}