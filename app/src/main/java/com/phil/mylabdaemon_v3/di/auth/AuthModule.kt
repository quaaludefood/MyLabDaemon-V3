package com.phil.mylabdaemon_v3.di.auth

import com.phil.mylabdaemon_v3.api.auth.OpenApiAuthService
import com.phil.mylabdaemon_v3.persistence.AccountPropertiesDao
import com.phil.mylabdaemon_v3.persistence.AuthTokenDao
import com.phil.mylabdaemon_v3.repository.auth.AuthRepository
import com.phil.mylabdaemon_v3.session.SessionManager
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AuthModule{

    // TEMPORARY
    @AuthScope
    @Provides
    fun provideFakeApiService(): OpenApiAuthService {
        return Retrofit.Builder()
            .baseUrl("http://mylabdaemon.thefusion.works/api/")
            .build()
            .create(OpenApiAuthService::class.java)
    }

    @AuthScope
    @Provides
    fun provideAuthRepository(
        sessionManager: SessionManager,
        authTokenDao: AuthTokenDao,
        accountPropertiesDao: AccountPropertiesDao,
        openApiAuthService: OpenApiAuthService
    ): AuthRepository {
        return AuthRepository(
            authTokenDao,
            accountPropertiesDao,
            openApiAuthService,
            sessionManager
        )
    }

}