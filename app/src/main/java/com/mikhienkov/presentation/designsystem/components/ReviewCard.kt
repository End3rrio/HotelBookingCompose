package com.mikhienkov.presentation.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mikhienkov.R
import com.mikhienkov.presentation.designsystem.theme.BookingTheme

@Composable
fun ReviewCard(
    text: String,
    modifier: Modifier = Modifier,
    authorName: String,
    avatarUrl: String,
    date: String,
    rating: String
) {
    Card(
        modifier = modifier,
        shape = BookingTheme.shapes.medium,
        elevation =CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        BackgroundSurface {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ReviewCardHeader(
                    modifier = Modifier.fillMaxWidth(),
                    userName = authorName,
                    avatarUrl = avatarUrl,
                    date = date,
                    rating = rating
                )
                Text(
                    text = text,
                    style = BookingTheme.typography.bodyMediumRegular,
                    color = BookingTheme.primaryTextColor
                )
            }
        }
    }
}

@Composable
private fun ReviewCardHeader(
    userName: String,
    avatarUrl: String,
    date: String,
    rating: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            model = avatarUrl,
            contentDescription = ""
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = userName,
                style = BookingTheme.typography.bodyLargeBold,
                color = BookingTheme.primaryTextColor
            )
            Text(
                text = date,
                style = BookingTheme.typography.bodySmallMedium,
                color = BookingTheme.secondaryTextColor
            )
        }
        Chip(
            toggled = true,
            onClick = { },
            text = rating,
            leadingIconResId = R.drawable.ic_star
        )
    }
}