package com.mikhienkov.domain.usecases

import com.mikhienkov.domain.repositories.AppPreferencesRepository
import com.mikhienkov.domain.valueobjects.AppPreferences
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetAppPreferencesUseCase {
    operator fun invoke(): Flow<AppPreferences>
}

class GetAppPreferencesUseCaseImpl @Inject constructor(
    private val appPreferencesRepository: AppPreferencesRepository
) : GetAppPreferencesUseCase {
    override fun invoke(): Flow<AppPreferences> {
        return appPreferencesRepository.appPreferences
    }
}