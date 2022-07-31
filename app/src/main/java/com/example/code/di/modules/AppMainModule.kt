package com.example.code.di.modules

import android.app.Application
import android.content.Context
import com.example.code.MyApp
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [AppActivityModule::class])
abstract class AppMainModule {

    @Singleton
    @Binds
    abstract fun context(application: Application):Context

    @Singleton
    @Binds
    abstract fun application(application: MyApp):Application
}