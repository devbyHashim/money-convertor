package com.example.code.di

import androidx.annotation.NonNull
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

interface ViewModelInjector<T : ViewModel>  {

    @NonNull
    fun  create( savedStateHandle: SavedStateHandle):T
}