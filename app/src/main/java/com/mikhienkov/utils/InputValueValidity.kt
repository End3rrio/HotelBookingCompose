package com.mikhienkov.utils

import androidx.core.util.PatternsCompat

fun isValidEmail(email: String): Boolean {
    val pattern = PatternsCompat.EMAIL_ADDRESS
    return pattern.matcher(email).matches()
}