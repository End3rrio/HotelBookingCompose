package com.mikhienkov.presentation.profile.security

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mikhienkov.presentation.designsystem.components.Dialog
import com.mikhienkov.presentation.designsystem.theme.BookingTheme
import com.mikhienkov.presentation.designsystem.components.Divider
import com.mikhienkov.presentation.designsystem.components.PrimaryButton
import com.mikhienkov.presentation.designsystem.components.SecondaryButton


@Composable
fun RecentLoginRequiredDialog(
    open: Boolean,
    title: String,
    body: String,
    positiveButtonText: String,
    negativeButtonText: String,
    onPositiveButtonClick: () -> Unit,
    onDismiss: () -> Unit
) {
    if (open) {
        Dialog(onDismissRequest = onDismiss) {
            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    color = BookingTheme.colors.error,
                    style = BookingTheme.typography.heading4
                )

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp)
                )

                Text(
                    text = body,
                    style = BookingTheme.typography.heading6,
                    color = if (BookingTheme.theme.isDark) BookingTheme.colors.white else BookingTheme.colors.greyscale800,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(24.dp))
                PrimaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = positiveButtonText,
                    onClick = onPositiveButtonClick
                )
                Spacer(modifier = Modifier.height(16.dp))
                SecondaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = negativeButtonText,
                    onClick = onDismiss
                )

            }
        }
    }
}