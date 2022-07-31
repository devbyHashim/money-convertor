package com.example.code.ui

import android.app.ProgressDialog
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.code.R
import com.example.code.databinding.ActivityMainBinding
import com.example.code.root.CustomViewModelStateFactory
import com.example.code.root.RootActivity
import javax.inject.Inject

class MainActivity : RootActivity() {
    @Inject
    lateinit var progressDialog: ProgressDialog
    @Inject
    lateinit var mainViewModelInjector: MainViewModelInjector
    private val viewModel by lazy {
        val factory = CustomViewModelStateFactory(mainViewModelInjector,this,null)
        ViewModelProvider(this,factory)[MainViewModel::class.java]
    }

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding
    viewModel
    }
}