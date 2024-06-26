package com.mikhienkov.domain.usecases

import com.google.firebase.auth.EmailAuthProvider
import com.mikhienkov.domain.repositories.UserRepository
import com.mikhienkov.utils.Result
import javax.inject.Inject

interface IsPasswordChangeAvailableUseCase {
    suspend operator fun invoke(): Result<Boolean>
}

class IsPasswordChangeAvailableUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : IsPasswordChangeAvailableUseCase {
    override suspend fun invoke(): Result<Boolean> {
        return try {
            val email = userRepository.currentUser!!.email!!
            val signInMethods = userRepository.getSignInMethodsForEmail(email)
            val passwordChangeAvailable = signInMethods.contains(
                EmailAuthProvider.EMAIL_PASSWORD_SIGN_IN_METHOD
            )
            Result.Success(passwordChangeAvailable)
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }

}