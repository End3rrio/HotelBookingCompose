package com.mikhienkov.domain.usecases

import android.net.Uri
import com.mikhienkov.domain.repositories.UserRepository
import com.mikhienkov.utils.Result
import com.mikhienkov.utils.asResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetUserPhotoUseCase {
    operator fun invoke(): Flow<Result<Uri?>>
}

class GetUserPhotoUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : GetUserPhotoUseCase {
    override fun invoke(): Flow<Result<Uri?>> {
        return userRepository.observeUserPhoto().asResult()
    }
}