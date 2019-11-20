package com.phil.mylabdaemon_v3.repository.auth

import com.phil.mylabdaemon_v3.api.auth.OpenApiAuthService
import com.phil.mylabdaemon_v3.persistence.AccountPropertiesDao
import com.phil.mylabdaemon_v3.persistence.AuthTokenDao
import com.phil.mylabdaemon_v3.session.SessionManager
import javax.inject.Inject

class AuthRepository
@Inject
constructor(
    val authTokenDao: AuthTokenDao,
    val accountPropertiesDao: AccountPropertiesDao,
    val  openApiAuthService: OpenApiAuthService,
    val  sessionManager: SessionManager

)
{}