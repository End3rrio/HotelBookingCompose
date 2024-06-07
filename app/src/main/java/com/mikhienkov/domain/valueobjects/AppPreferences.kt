package com.mikhienkov.domain.valueobjects

data class AppPreferences(
    val theme: Theme,
    val showOnboarding: Boolean,
    val rememberMe: Boolean
)
