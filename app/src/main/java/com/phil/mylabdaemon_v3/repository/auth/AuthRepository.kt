package com.phil.mylabdaemon_v3.repository.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.switchMap
import com.phil.mylabdaemon_v3.api.auth.OpenApiAuthService
import com.phil.mylabdaemon_v3.api.auth.network_responses.LoginResponse
import com.phil.mylabdaemon_v3.api.auth.network_responses.RegistrationResponse
import com.phil.mylabdaemon_v3.models.AuthToken
import com.phil.mylabdaemon_v3.persistence.AccountPropertiesDao
import com.phil.mylabdaemon_v3.persistence.AuthTokenDao
import com.phil.mylabdaemon_v3.session.SessionManager
import com.phil.mylabdaemon_v3.ui.DataState
import com.phil.mylabdaemon_v3.ui.Response
import com.phil.mylabdaemon_v3.ui.ResponseType
import com.phil.mylabdaemon_v3.ui.auth.state.AuthViewState
import com.phil.mylabdaemon_v3.ui.auth.state.LoginFields
import com.phil.mylabdaemon_v3.util.ApiEmptyResponse
import com.phil.mylabdaemon_v3.util.ApiErrorResponse
import com.phil.mylabdaemon_v3.util.ApiSuccessResponse
import com.phil.mylabdaemon_v3.util.ErrorHandling.Companion.ERROR_UNKNOWN
import com.phil.mylabdaemon_v3.util.GenericApiResponse
import javax.inject.Inject

class AuthRepository
@Inject
constructor(
    val authTokenDao: AuthTokenDao,
    val accountPropertiesDao: AccountPropertiesDao,
    val openApiAuthService: OpenApiAuthService,
    val sessionManager: SessionManager
)
{

    fun attemptLogin(email: String, password: String): LiveData<DataState<AuthViewState>>{
        return openApiAuthService.login(email, password)
            .switchMap { response ->
                object: LiveData<DataState<AuthViewState>>(){
                    override fun onActive() {
                        super.onActive()
                        when(response){
                            is ApiSuccessResponse ->{
                                value = DataState.data(
                                    AuthViewState(
                                        authToken = AuthToken(response.body.pk, response.body.token)
                                    ),
                                    response = null
                                )
                            }
                            is ApiErrorResponse ->{
                                value = DataState.error(
                                    Response(
                                        message = response.errorMessage,
                                        responseType = ResponseType.Dialog()
                                    )
                                )
                            }
                            is ApiEmptyResponse ->{
                                value = DataState.error(
                                    Response(
                                        message = ERROR_UNKNOWN,
                                        responseType = ResponseType.Dialog()
                                    )
                                )
                            }
                        }
                    }
                }
            }
    }


    fun attemptRegistration(
        email: String,
        username: String,
        password: String,
        confirmPassword: String
    ): LiveData<DataState<AuthViewState>>{
        return openApiAuthService.register(email, username, password, confirmPassword)
            .switchMap { response ->
                object: LiveData<DataState<AuthViewState>>(){
                    override fun onActive() {
                        super.onActive()
                        when(response){
                            is ApiSuccessResponse ->{
                                value = DataState.data(
                                    AuthViewState(
                                        authToken = AuthToken(response.body.pk, response.body.token)
                                    ),
                                    response = null
                                )
                            }
                            is ApiErrorResponse ->{
                                value = DataState.error(
                                    Response(
                                        message = response.errorMessage,
                                        responseType = ResponseType.Dialog()
                                    )
                                )
                            }
                            is ApiEmptyResponse ->{
                                value = DataState.error(
                                    Response(
                                        message = ERROR_UNKNOWN,
                                        responseType = ResponseType.Dialog()
                                    )
                                )
                            }
                        }
                    }
                }
            }
    }

}






