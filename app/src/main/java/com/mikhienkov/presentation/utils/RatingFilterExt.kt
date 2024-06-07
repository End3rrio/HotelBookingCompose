package com.mikhienkov.presentation.utils

import com.mikhienkov.R
import com.mikhienkov.domain.valueobjects.RatingFilter

fun RatingFilter.asStringRes() = when (this) {
    RatingFilter.ALL -> R.string.rating_filter_all
    RatingFilter.FIVE -> R.string.rating_filter_five
    RatingFilter.FOUR -> R.string.rating_filter_four
    RatingFilter.THREE -> R.string.rating_filter_three
    RatingFilter.TWO -> R.string.rating_filter_two
}