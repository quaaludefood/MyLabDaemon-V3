package com.phil.mylabdaemon_v3.session

import android.app.Application
import com.phil.mylabdaemon_v3.persistence.AuthTokenDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager
@Inject
constructor(
    val authTokenDao: AuthTokenDao,
    val  application: Application

)
{}