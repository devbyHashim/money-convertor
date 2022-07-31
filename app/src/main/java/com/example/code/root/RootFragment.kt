package com.example.code.root

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection

open class RootFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        AndroidSupportInjection.inject(this)
    }
}