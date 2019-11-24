package com.phil.mylabdaemon_v3.ui.auth.state

sealed class AuthStateEvent {
    data class LoginAttemptEvent(
        val email: String,
        val username: String
    ):AuthStateEvent()

    data class RegisterAttemptEvent(
        val email: String,
        val username: String,
        val password: String,
        val confirm_password: String
    ):AuthStateEvent()

    class CheckPreviousAuthEvent: AuthStateEvent()
}