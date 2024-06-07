package com.mikhienkov.presentation.utils

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import com.mikhienkov.R
import com.mikhienkov.designsystem.components.HotelDisplayMode

@SuppressLint("ComposableNaming")
@Composable
fun HotelDisplayMode.getTintWithCurrentMode(
    currentHotelDisplayMode: HotelDisplayMode
) = if (this == currentHotelDisplayMode) {
    com.mikhienkov.designsystem.theme.BookingTheme.colors.primary500
} else if (com.mikhienkov.designsystem.theme.BookingTheme.theme.isDark) {
    com.mikhienkov.designsystem.theme.BookingTheme.colors.white
} else {
    com.mikhienkov.designsystem.theme.BookingTheme.colors.greyscale900
}


fun HotelDisplayMode.getIconResWithCurrentMode(currentHotelDisplayMode: HotelDisplayMode): Int {
    return when (this) {
        HotelDisplayMode.LIST ->
            if (this == currentHotelDisplayMode) R.drawable.ic_document else R.drawable.ic_document_border

        HotelDisplayMode.GRID ->
            if (this == currentHotelDisplayMode) R.drawable.ic_category else R.drawable.ic_category_border
    }
}