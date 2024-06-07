package com.mikhienkov.domain.usecases

import com.mikhienkov.domain.entities.User
import com.mikhienkov.domain.repositories.UserRepository
import com.mikhienkov.utils.Result
import javax.inject.Inject

interface GetUserUseCase {
    suspend operator fun invoke(): Result<User>
}

class GetUserUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : GetUserUseCase {
    override suspend fun invoke(): Result<User> {
        return try {
            Result.Success(userRepository.getUser())
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }
}