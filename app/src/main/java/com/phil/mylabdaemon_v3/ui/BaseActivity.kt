package com.phil.mylabdaemon_v3.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.phil.mylabdaemon_v3.session.SessionManager
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import javax.inject.Provider

abstract class BaseActivity : DaggerAppCompatActivity(){

    val TAG: String = "AppDebug"

    @Inject
    lateinit var sessionManager: SessionManager
}