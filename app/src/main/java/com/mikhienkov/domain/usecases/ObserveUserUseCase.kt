package com.mikhienkov.domain.usecases

import com.mikhienkov.domain.entities.User
import com.mikhienkov.domain.repositories.UserRepository
import com.mikhienkov.utils.Result
import com.mikhienkov.utils.asResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ObserveUserUseCase {
    operator fun invoke(): Flow<Result<User>>
}

class ObserveUserUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : ObserveUserUseCase {
    override fun invoke(): Flow<Result<User>> {
        return userRepository.observeUser().asResult()
    }
}