package com.mikhienkov.presentation.profile.edit

import com.mikhienkov.domain.valueobjects.Gender
import java.time.LocalDate

sealed interface EditProfileIntent {
    object Update : EditProfileIntent
    object ErrorShown : EditProfileIntent
    data class InputFullName(val name: String) : EditProfileIntent
    data class UpdateDateOfBirth(val date: LocalDate) : EditProfileIntent
    data class UpdateGender(val gender: Gender) : EditProfileIntent
}