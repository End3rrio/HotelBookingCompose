package com.mikhienkov.presentation.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mikhienkov.presentation.designsystem.theme.BookingTheme

@Composable
fun Divider(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(if (BookingTheme.theme.isDark) BookingTheme.colors.dark3 else BookingTheme.colors.greyscale200)
    )
}

@Composable
fun Divider(
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(if (BookingTheme.theme.isDark) BookingTheme.colors.dark3 else BookingTheme.colors.greyscale200)
        )
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = text,
            color = if (BookingTheme.theme.isDark) BookingTheme.colors.greyscale100 else BookingTheme.colors.greyscale700,
            style = BookingTheme.typography.bodyXLargeSemiBold
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(if (BookingTheme.theme.isDark) BookingTheme.colors.dark3 else BookingTheme.colors.greyscale200)
        )
    }
}