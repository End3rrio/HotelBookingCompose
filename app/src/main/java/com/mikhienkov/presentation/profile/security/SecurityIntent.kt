package com.mikhienkov.presentation.profile.security

sealed interface SecurityIntent {
    object DeleteProfile : SecurityIntent
    object ChangePassword : SecurityIntent
    data class ToggleRememberMe(val rememberMe: Boolean) : SecurityIntent

    object ChangePasswordHandled : SecurityIntent
    object DismissRecentLoginRequiredDialog : SecurityIntent
    object SignOut : SecurityIntent
}