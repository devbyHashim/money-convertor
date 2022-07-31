package com.example.code.root

import android.os.Bundle
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.code.di.ViewModelInjector

class CustomViewModelStateFactory constructor(@NonNull val viewModelInjector: ViewModelInjector<*>,
                                              @NonNull val owner: SavedStateRegistryOwner,
                                              @Nullable val defaultArgs: Bundle?) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {



    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return (viewModelInjector.create(handle) as? T)!!
    }
}