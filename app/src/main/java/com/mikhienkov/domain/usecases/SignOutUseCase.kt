package com.mikhienkov.domain.usecases

import com.mikhienkov.domain.repositories.UserRepository
import javax.inject.Inject

interface SignOutUseCase {
    suspend operator fun invoke()
}

class SignOutUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : SignOutUseCase {
    override suspend fun invoke() {
        try {
            userRepository.signOut()
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }
}