package com.phil.mylabdaemon_v3.ui.auth

import androidx.lifecycle.ViewModel
import com.phil.mylabdaemon_v3.repository.auth.AuthRepository
import javax.inject.Inject

class AuthViewModel
@Inject
constructor(
    val authRepository: AuthRepository

) : ViewModel()
{
}