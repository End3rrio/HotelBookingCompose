package com.mikhienkov.presentation.utils

import com.mikhienkov.R
import com.mikhienkov.domain.valueobjects.Gender

val Gender.nameStringResId
    get() = when (this) {
        Gender.MALE -> R.string.gender_male
        Gender.FEMALE -> R.string.gender_female
    }