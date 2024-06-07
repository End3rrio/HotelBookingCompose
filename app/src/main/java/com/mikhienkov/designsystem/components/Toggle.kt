package com.mikhienkov.designsystem.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mikhienkov.designsystem.theme.BookingTheme


private object ToggleDefaults {
    @Composable
    fun thumbColor() = BookingTheme.colors.white

    @Composable
    fun checkedTrackColor() = BookingTheme.colors.primary500

    @Composable
    fun uncheckedTrackColor() =
        if (BookingTheme.theme.isDark) BookingTheme.colors.dark2 else BookingTheme.colors.greyscale200
}

@Composable
fun Toggle(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = SwitchDefaults.colors(
        checkedIconColor = Color.Transparent,
        checkedThumbColor = ToggleDefaults.thumbColor(),
        uncheckedThumbColor = ToggleDefaults.thumbColor(),
        checkedTrackColor = ToggleDefaults.checkedTrackColor(),
        uncheckedTrackColor = ToggleDefaults.uncheckedTrackColor(),
        uncheckedBorderColor = ToggleDefaults.uncheckedTrackColor()
    )
    Switch(
        modifier = modifier,
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = colors,
        thumbContent = { Box(modifier = Modifier) }
    )
}