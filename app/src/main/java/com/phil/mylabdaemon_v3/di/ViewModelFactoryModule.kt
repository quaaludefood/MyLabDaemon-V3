package com.phil.mylabdaemon_v3.di

import androidx.lifecycle.ViewModelProvider
import com.phil.mylabdaemon_v3.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}