package com.mikhienkov.presentation.hoteldetails.review

import com.mikhienkov.domain.valueobjects.RatingFilter

sealed interface ReviewIntent {
    data class UpdateRatingFilter(val ratingFilter: RatingFilter) : ReviewIntent
}