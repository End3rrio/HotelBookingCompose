package com.mikhienkov.presentation.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color


@Stable
data class DarkTheme(val isDark: Boolean = false)

val LocalTheme = compositionLocalOf { DarkTheme() }

@Composable
fun BookingTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val theme = DarkTheme(darkTheme)
    CompositionLocalProvider(
        LocalBookingTypography provides bookingTypography,
        LocalBookingShapes provides bookingShapes,
        LocalBookingColorSchema provides bookingColorSchema,
        LocalTheme provides theme
    ) {
        MaterialTheme(content = content)
    }
}

object BookingTheme {
    val typography: BookingTypography
        @Composable
        get() = LocalBookingTypography.current
    val shapes: BookingShapes
        @Composable
        get() = LocalBookingShapes.current
    val colors: BookingColorSchema
        @Composable
        get() = LocalBookingColorSchema.current
    val theme: DarkTheme
        @Composable
        get() = LocalTheme.current

    val primaryTextColor
        @Composable get() = if (theme.isDark) colors.white else colors.greyscale900

    val secondaryTextColor
        @Composable get() = if (theme.isDark) colors.greyscale100 else colors.greyscale800

    val backgroundColor
        @Composable get() = if (theme.isDark) colors.dark1 else colors.white
}


object LoginSocialButtonRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = BookingTheme.colors.primary200

    @Composable
    override fun rippleAlpha(): RippleAlpha {
        return RippleTheme.defaultRippleAlpha(Color.Black, lightTheme = !isSystemInDarkTheme())
    }

}