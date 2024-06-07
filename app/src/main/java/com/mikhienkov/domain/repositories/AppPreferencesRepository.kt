package com.mikhienkov.domain.repositories

import com.mikhienkov.domain.valueobjects.AppPreferences
import com.mikhienkov.domain.valueobjects.Theme
import kotlinx.coroutines.flow.Flow


interface AppPreferencesRepository {
    val appPreferences: Flow<AppPreferences>
    suspend fun updateThemePreference(theme: Theme)
    suspend fun updateShowOnboarding(show: Boolean)
    suspend fun updateRememberMe(remember: Boolean)
}