package com.mikhienkov.presentation.hoteldetails.review

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mikhienkov.R
import com.mikhienkov.designsystem.components.Chip
import com.mikhienkov.designsystem.components.Navbar
import com.mikhienkov.designsystem.components.ReviewCard
import com.mikhienkov.designsystem.components.ReviewsLabel
import com.mikhienkov.designsystem.theme.BookingTheme
import com.mikhienkov.domain.entities.HotelDetails
import com.mikhienkov.domain.valueobjects.RatingFilter
import com.mikhienkov.presentation.utils.asStringRes
import com.mikhienkov.presentation.utils.toUiString

@Composable
fun ReviewScreen(
    onNavigationClick: () -> Unit,
    viewModel: ReviewScreenViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    ReviewScreenContent(
        modifier = Modifier.fillMaxWidth(),
        state = state,
        onNavigationClick = onNavigationClick,
        onRatingClick = {
            viewModel.handleIntent(ReviewIntent.UpdateRatingFilter(it))
        }
    )
}

@Composable
private fun ReviewScreenContent(
    state: ReviewUiState,
    onNavigationClick: () -> Unit,
    onRatingClick: (RatingFilter) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Navbar(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(start = 16.dp, end = 24.dp),
            title = stringResource(R.string.review_screen_title),
            onNavigateClick = onNavigationClick,
            actions = {}
        )

        RatingFilterRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            selectedRatingFilter = state.ratingFilter,
            onRatingClick = onRatingClick
        )

        ReviewsContent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            state = state
        )
    }
}

@Composable
private fun ReviewsContent(
    state: ReviewUiState,
    modifier: Modifier = Modifier
) {
    AnimatedContent(
        modifier = modifier,
        targetState = state.type,
        label = ""
    ) { type ->
        when (type) {
            ReviewUiState.Type.LOADING -> {
                LoadingPlaceholder(Modifier.fillMaxSize())
            }

            ReviewUiState.Type.ERROR -> TODO()
            ReviewUiState.Type.EMPTY -> {
                EmptyPlaceholder(Modifier.fillMaxSize())
            }

            ReviewUiState.Type.DATA -> {
                Reviews(
                    modifier = Modifier.fillMaxWidth(),
                    reviews = state.filteredReviews,
                    numberOfReviews = state.numberOfReviews,
                    rating = state.averageRating
                )
            }
        }
    }
}

@Composable
private fun LoadingPlaceholder(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(color = BookingTheme.colors.primary500)
    }
}

@Composable
private fun EmptyPlaceholder(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "No reviews found.",
            style = BookingTheme.typography.bodyLargeRegular,
            color = BookingTheme.primaryTextColor
        )
    }
}


@Composable
private fun RatingFilterRow(
    selectedRatingFilter: RatingFilter,
    onRatingClick: (RatingFilter) -> Unit,
    modifier: Modifier = Modifier
) {
    val ratingOptions = remember { RatingFilter.values() }

    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = ratingOptions, key = { it.ordinal }) { option ->
            Chip(
                toggled = option == selectedRatingFilter,
                onClick = { onRatingClick(option) },
                text = stringResource(option.asStringRes()),
                leadingIconResId = R.drawable.ic_star
            )
        }
    }
}


@Composable
private fun Reviews(
    reviews: List<HotelDetails.Review>,
    numberOfReviews: Int,
    rating: Double,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.hotel_reviews_screen_rating),
                style = BookingTheme.typography.bodyLargeSemiBold,
                color = BookingTheme.primaryTextColor
            )
            ReviewsLabel(
                numberOfReview = numberOfReviews,
                rating = rating.toString()
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(items = reviews, key = { it.hashCode() }) { review ->
                ReviewCard(
                    modifier = Modifier.fillMaxWidth(),
                    text = review.text,
                    authorName = review.author.name,
                    avatarUrl = review.author.avatarUrl,
                    date = review.created.toUiString(),
                    rating = review.rating.toString()
                )
            }
        }
    }
}