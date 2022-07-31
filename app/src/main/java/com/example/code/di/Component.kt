package com.example.code.di

import com.example.code.MyApp
import com.example.code.di.modules.AppMainModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class , AndroidSupportInjectionModule::class , AppMainModule::class])
interface Component : AndroidInjector<MyApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Factory<MyApp>{


        override fun create(instance: MyApp?): AndroidInjector<MyApp> {
            seedInstance(instance!!)
            return build()
        }

        @BindsInstance
        abstract fun seedInstance(application: MyApp)
        abstract fun build():AndroidInjector<MyApp>
    }
}