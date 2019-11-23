package com.phil.mylabdaemon_v3.repository.auth

import androidx.lifecycle.LiveData
import com.phil.mylabdaemon_v3.api.auth.OpenApiAuthService
import com.phil.mylabdaemon_v3.di.auth.network_responses.LoginResponse
import com.phil.mylabdaemon_v3.di.auth.network_responses.RegistrationResponse
import com.phil.mylabdaemon_v3.persistence.AccountPropertiesDao
import com.phil.mylabdaemon_v3.persistence.AuthTokenDao
import com.phil.mylabdaemon_v3.session.SessionManager
import com.phil.mylabdaemon_v3.util.GenericApiResponse
import javax.inject.Inject

class AuthRepository
@Inject
constructor(
    val authTokenDao: AuthTokenDao,
    val accountPropertiesDao: AccountPropertiesDao,
    val  openApiAuthService: OpenApiAuthService,
    val  sessionManager: SessionManager

)
{
    fun testLoginRequest(email: String, password: String) : LiveData<GenericApiResponse<LoginResponse>> {
        return openApiAuthService.login(email, password)
    }

    fun testRegistration(email: String, username: String, password: String, confirmPassword: String) : LiveData<GenericApiResponse<RegistrationResponse>> {
        return openApiAuthService.register(email, username, password, confirmPassword)
    }

}