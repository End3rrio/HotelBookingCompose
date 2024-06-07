package com.mikhienkov.presentation.designsystem.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.mikhienkov.presentation.designsystem.theme.BookingTheme

@Composable
fun AuthenticationHeading(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Left
) {
    Text(
        modifier = modifier,
        text = text,
        style = BookingTheme.typography.heading3,
        color = if (BookingTheme.theme.isDark) BookingTheme.colors.white else BookingTheme.colors.greyscale900,
        textAlign = textAlign
    )
}