package com.phil.mylabdaemon_v3.di.auth

import com.phil.mylabdaemon_v3.ui.auth.ForgotPasswordFragment
import com.phil.mylabdaemon_v3.ui.auth.LauncherFragment
import com.phil.mylabdaemon_v3.ui.auth.LoginFragment
import com.phil.mylabdaemon_v3.ui.auth.RegisterFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AuthFragmentBuildersModule {

    @ContributesAndroidInjector()
    abstract fun contributeLauncherFragment(): LauncherFragment

    @ContributesAndroidInjector()
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector()
    abstract fun contributeRegisterFragment(): RegisterFragment

    @ContributesAndroidInjector()
    abstract fun contributeForgotPasswordFragment(): ForgotPasswordFragment

}