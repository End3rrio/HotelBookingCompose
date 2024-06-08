package com.mikhienkov.domain.usecases

import javax.inject.Inject

interface ValidatePasswordUseCase {
    operator fun invoke(password: String): Boolean
}

class ValidatePasswordUseCaseImpl @Inject constructor() : ValidatePasswordUseCase {
    override fun invoke(password: String): Boolean {
        return password.length >= 6
    }
}