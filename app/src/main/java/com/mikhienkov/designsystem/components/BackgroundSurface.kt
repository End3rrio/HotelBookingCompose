package com.mikhienkov.designsystem.components

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mikhienkov.designsystem.theme.BookingTheme

@Composable
fun BackgroundSurface(
    modifier: Modifier = Modifier,
    color: Color = BookingTheme.backgroundColor,
    content: @Composable () -> Unit
) {
    Surface(modifier = modifier, color = color, content = content)
}