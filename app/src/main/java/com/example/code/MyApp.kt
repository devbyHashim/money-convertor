package com.example.code

import android.app.Application
import com.example.code.di.DaggerComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject
class MyApp : Application (), HasAndroidInjector {

    @Inject
    lateinit var injection : DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerComponent.builder().create(this).inject(this)
    }


    override fun androidInjector(): AndroidInjector<Any> {
        return injection
    }
}