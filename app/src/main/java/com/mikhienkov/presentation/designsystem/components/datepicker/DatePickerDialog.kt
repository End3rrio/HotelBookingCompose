package com.mikhienkov.presentation.designsystem.components.datepicker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.mikhienkov.R
import com.mikhienkov.presentation.designsystem.components.Dialog
import com.mikhienkov.presentation.designsystem.theme.BookingTheme
import com.mikhienkov.presentation.designsystem.theme.LoginSocialButtonRippleTheme
import com.mikhienkov.presentation.utils.toLocalDate
import com.mikhienkov.presentation.utils.toMillis
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDialog(
    open: Boolean,
    onDismiss: () -> Unit,
    onSelect: (date: LocalDate) -> Unit,
    initialSelectedDate: LocalDate? = null
) {
    if (open) {
        val datePickerState = rememberDatePickerState(
            initialSelectedDateMillis = initialSelectedDate?.toMillis(),
        )
        MaterialTheme(
            // onSurfaceVariant color is used by YearPickerMenuButton
            colorScheme = MaterialTheme.colorScheme.copy(
                onSurfaceVariant = BookingDatePickerDefaults.contentColor
            )
        ) {
            // LocalContentColor is used by MonthsNavigation icon buttons
            CompositionLocalProvider(LocalContentColor provides BookingDatePickerDefaults.contentColor) {
                Dialog(
                    onDismissRequest = onDismiss,
                    properties = DialogProperties(usePlatformDefaultWidth = false)
                ) {
                    Column(modifier = Modifier) {
                        DatePicker(
                            modifier = Modifier,
                            state = datePickerState,
                            colors = BookingDatePickerDefaults.colors(),
                            title = null,
                            headline = null,
                            showModeToggle = false
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            CancelButton(onClick = { onDismiss() })
                            Spacer(modifier = Modifier.width(32.dp))
                            ConfirmButton(
                                enabled = datePickerState.selectedDateMillis != null,
                                onClick = {
                                    datePickerState.selectedDateMillis?.let { millis ->
                                        onSelect(millis.toLocalDate())
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun CancelButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    CompositionLocalProvider(LocalRippleTheme provides LoginSocialButtonRippleTheme) {
        androidx.compose.material3.TextButton(
            modifier = modifier,
            onClick = onClick,
        ) {
            Text(
                text = stringResource(R.string.cancel),
                color = if (BookingTheme.theme.isDark) BookingTheme.colors.white else BookingTheme.colors.greyscale900
            )
        }
    }
}

@Composable
private fun ConfirmButton(
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    CompositionLocalProvider(LocalRippleTheme provides LoginSocialButtonRippleTheme) {
        androidx.compose.material3.TextButton(
            modifier = modifier,
            onClick = onClick,
            enabled = enabled,
            colors = ButtonDefaults.textButtonColors(
                contentColor = BookingTheme.colors.primary500,
                disabledContentColor = BookingTheme.colors.greyscale500
            )
        ) {
            Text(text = stringResource(R.string.confirm))
        }
    }
}