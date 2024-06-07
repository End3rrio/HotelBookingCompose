package com.mikhienkov.designsystem.components.datepicker

import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.mikhienkov.designsystem.theme.BookingTheme

object BookingDatePickerDefaults {
    val contentColor
        @Composable
        get() = if (BookingTheme.theme.isDark) BookingTheme.colors.white else BookingTheme.colors.greyscale900

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun colors() = DatePickerDefaults.colors(
        containerColor = BookingTheme.backgroundColor,
        weekdayContentColor = contentColor,
        yearContentColor = contentColor,
        currentYearContentColor = contentColor,
        selectedYearContentColor = BookingTheme.colors.white,
        selectedYearContainerColor = BookingTheme.colors.primary500,
        subheadContentColor = contentColor,
        todayDateBorderColor = BookingTheme.colors.primary500,
        dayContentColor = contentColor,
        todayContentColor = contentColor,
        selectedDayContainerColor = BookingTheme.colors.primary500,
        selectedDayContentColor = BookingTheme.colors.white
    )
}