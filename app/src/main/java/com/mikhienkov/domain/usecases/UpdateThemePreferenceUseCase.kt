package com.mikhienkov.domain.usecases

import com.mikhienkov.domain.repositories.AppPreferencesRepository
import com.mikhienkov.domain.valueobjects.Theme
import com.mikhienkov.utils.Result
import javax.inject.Inject

interface UpdateThemePreferenceUseCase {
    suspend operator fun invoke(theme: Theme): Result<Unit>
}

class UpdateThemePreferenceUseCaseImpl @Inject constructor(
    private val appPreferencesRepository: AppPreferencesRepository
) : UpdateThemePreferenceUseCase {
    override suspend fun invoke(theme: Theme): Result<Unit> {
        return try {
            appPreferencesRepository.updateThemePreference(theme)
            Result.Success(Unit)
        } catch (e: Throwable) {
            Result.Error(e)
        }
    }
}