package com.phil.mylabdaemon_v3.ui


import com.phil.mylabdaemon_v3.session.SessionManager
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


abstract class BaseActivity : DaggerAppCompatActivity(){

    val TAG: String = "AppDebug"

    @Inject
    lateinit var sessionManager: SessionManager
}