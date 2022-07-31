package com.example.code.di.modules.sub

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.code.di.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Provides
    @ActivityScope
    fun loader(appCompatActivity: AppCompatActivity):ProgressDialog {
        return ProgressDialog(appCompatActivity)
    }
}