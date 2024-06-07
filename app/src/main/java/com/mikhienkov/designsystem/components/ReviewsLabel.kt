package com.mikhienkov.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mikhienkov.R
import com.mikhienkov.designsystem.theme.BookingTheme

@Composable
fun ReviewsLabel(
    numberOfReview: Int,
    rating: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = "",
            tint = BookingTheme.colors.secondary500
        )
        Text(
            modifier = Modifier.padding(start = 4.dp, end = 8.dp),
            text = rating,
            style = BookingTheme.typography.bodyLargeSemiBold,
            color = BookingTheme.colors.primary500
        )
        Text(
            text = stringResource(id = R.string.number_of_reviews, numberOfReview),
            style = BookingTheme.typography.bodySmallRegular,
            color = if (BookingTheme.theme.isDark) BookingTheme.colors.greyscale300 else BookingTheme.colors.greyscale600
        )
    }
}