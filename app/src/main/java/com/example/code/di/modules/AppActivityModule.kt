package com.example.code.di.modules


import com.example.code.di.ActivityScope
import com.example.code.ui.MainActivity
import com.example.code.ui.MainActivityDiModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityDiModule::class])
    abstract fun mainActivity():MainActivity

}