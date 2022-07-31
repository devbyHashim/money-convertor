package com.example.code.ui

import androidx.appcompat.app.AppCompatActivity
import com.example.code.di.modules.sub.ActivityModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [ActivityModule::class])
abstract class MainActivityDiModule {
    @Binds
    abstract fun activity(mainActivity: MainActivity):AppCompatActivity

    @ContributesAndroidInjector
    abstract fun mainFragment():MainFragment
}