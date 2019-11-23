package com.phil.mylabdaemon_v3.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.phil.mylabdaemon_v3.di.auth.network_responses.LoginResponse
import com.phil.mylabdaemon_v3.di.auth.network_responses.RegistrationResponse
import com.phil.mylabdaemon_v3.repository.auth.AuthRepository
import com.phil.mylabdaemon_v3.util.GenericApiResponse
import javax.inject.Inject

class AuthViewModel
@Inject
constructor(
    val authRepository: AuthRepository

) : ViewModel()
{

    fun testLogin(): LiveData<GenericApiResponse<LoginResponse>> {
        return authRepository.testLoginRequest("username",
            "password"
        )
    }

    fun testRegister(): LiveData<GenericApiResponse<RegistrationResponse>> {
        return authRepository.testRegistration(
            "mitchelltabian@gmail1234.com",
            "mitchelltabian1234",
            "codingwithmitch1",
            "codingwithmitch1"
        )
    }
}