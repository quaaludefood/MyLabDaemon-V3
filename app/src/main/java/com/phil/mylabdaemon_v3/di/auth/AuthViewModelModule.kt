package com.phil.mylabdaemon_v3.di.auth

import androidx.lifecycle.ViewModel
import com.phil.mylabdaemon_v3.di.ViewModelKey
import com.phil.mylabdaemon_v3.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(authViewModel: AuthViewModel): ViewModel

}