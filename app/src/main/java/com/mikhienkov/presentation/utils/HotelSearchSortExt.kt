package com.mikhienkov.presentation.utils

import com.mikhienkov.R
import com.mikhienkov.domain.valueobjects.HotelSearchFilter
import com.mikhienkov.domain.valueobjects.HotelSearchFilter.HotelSearchSort.*

fun HotelSearchFilter.HotelSearchSort.asStringRes() = when (this) {
    REVIEW_SCORE -> R.string.search_screen_sort_option_review_score
    HIGHEST_PRICE -> R.string.search_screen_sort_option_highest_price
    LOWEST_PRICE -> R.string.search_screen_sort_option_lowest_price
}