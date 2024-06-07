package com.mikhienkov.presentation.designsystem.components

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mikhienkov.presentation.designsystem.theme.BookingTheme

@Composable
fun BackgroundSurface(
    modifier: Modifier = Modifier,
    color: Color = BookingTheme.backgroundColor,
    content: @Composable () -> Unit
) {
    Surface(modifier = modifier, color = color, content = content)
}