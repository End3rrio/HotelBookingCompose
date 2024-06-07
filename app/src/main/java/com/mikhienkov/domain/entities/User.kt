package com.mikhienkov.domain.entities

import android.net.Uri
import com.mikhienkov.domain.valueobjects.Gender
import java.time.LocalDate

data class User(
    val email: String?,
    val fullName: String?,
    val photoUri: Uri?,
    val gender: Gender?,
    val dateOfBirth: LocalDate?
)