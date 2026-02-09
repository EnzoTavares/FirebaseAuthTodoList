package com.example.firebaseauthtodolist.ui.feature.login

import com.example.firebaseauthtodolist.ui.feature.addedit.AddEditEvent

sealed interface LoginEvent {
    data class EmailChanged(val email: String) : LoginEvent
    data class PasswordChanged(val password: String) : LoginEvent
    data object Login : LoginEvent
    data object NavigateToSignup : LoginEvent
}