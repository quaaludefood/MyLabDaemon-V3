package com.phil.mylabdaemon_v3.di

import com.phil.mylabdaemon_v3.di.auth.AuthFragmentBuildersModule
import com.phil.mylabdaemon_v3.di.auth.AuthModule
import com.phil.mylabdaemon_v3.di.auth.AuthScope
import com.phil.mylabdaemon_v3.di.auth.AuthViewModelModule
import com.phil.mylabdaemon_v3.ui.auth.AuthActivity
import com.phil.mylabdaemon_v3.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(
        modules = [AuthModule::class, AuthFragmentBuildersModule::class, AuthViewModelModule::class]
    )
    abstract fun contributeAuthActivity(): AuthActivity

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

}