package com.phil.mylabdaemon_v3.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import javax.inject.Provider

abstract class BaseActivity : DaggerAppCompatActivity(){

    val TAG: String = "Debug: DaggerAppCompatActivity"
}