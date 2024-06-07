package com.mikhienkov.domain.usecases

import com.mikhienkov.utils.isValidEmail
import javax.inject.Inject

interface ValidateEmailUseCase {
    operator fun invoke(email: String): Boolean
}

class ValidateEmailUseCaseImpl @Inject constructor() : ValidateEmailUseCase {
    override operator fun invoke(email: String): Boolean {
        return isValidEmail(email)
    }
}
