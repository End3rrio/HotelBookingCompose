package com.mikhienkov.domain.usecases

import android.net.Uri
import com.mikhienkov.domain.repositories.UserRepository
import com.mikhienkov.utils.Result
import javax.inject.Inject

interface UpdateUserPhotoUseCase {
    suspend operator fun invoke(photoUri: Uri?): Result<Unit>
}

class UpdateUserPhotoUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : UpdateUserPhotoUseCase {
    override suspend fun invoke(photoUri: Uri?): Result<Unit> {
        return try {
            val downloadUri = photoUri?.let { userRepository.uploadPhoto(it) }
            userRepository.updateUserPhoto(downloadUri)
            Result.Success(Unit)
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }
}