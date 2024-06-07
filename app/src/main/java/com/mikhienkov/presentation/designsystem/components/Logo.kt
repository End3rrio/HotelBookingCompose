package com.mikhienkov.presentation.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mikhienkov.R
import com.mikhienkov.presentation.designsystem.theme.BookingTheme

@Composable
fun LogoIcon(
    modifier: Modifier = Modifier,
    size: Dp = 32.dp,
    shape: Shape = BookingTheme.shapes.small
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(shape)
            .background(Brush.linearGradient(BookingTheme.colors.gradientGreen)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.padding(3.dp),
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            tint = BookingTheme.colors.white
        )
    }
}

@Composable
fun LogoRow(
    text: String,
    modifier: Modifier = Modifier,
    size: Dp = 32.dp,
    shape: Shape = BookingTheme.shapes.small,
    textStyle: TextStyle = BookingTheme.typography.heading4
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LogoIcon(size = size, shape = shape)
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            style = textStyle,
            color = if (BookingTheme.theme.isDark) BookingTheme.colors.white else BookingTheme.colors.greyscale900
        )
    }
}