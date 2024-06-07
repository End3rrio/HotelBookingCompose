package com.mikhienkov.presentation.search

import com.mikhienkov.presentation.designsystem.components.HotelDisplayMode
import com.mikhienkov.domain.valueobjects.HotelCategory
import com.mikhienkov.domain.valueobjects.HotelFacility
import com.mikhienkov.domain.valueobjects.HotelSearchFilter

sealed interface SearchIntent {
    data class ChangeDisplayMode(val displayMode: HotelDisplayMode) : SearchIntent
    data class UpdateSearchValue(val value: String) : SearchIntent
    data class UpdateSearchBarFocus(val isFocused: Boolean) : SearchIntent
    data class ChangeHotelCategory(val category: HotelCategory?) : SearchIntent
    data class DeleteRecentSearchQuery(val id: String) : SearchIntent
    data class BookmarkHotel(val id: String, val isBookmarked: Boolean) : SearchIntent
    data class ClickCountry(val country: String) : SearchIntent
    data class ClickFacility(val facility: HotelFacility) : SearchIntent
    data class ClickSort(val sort: HotelSearchFilter.HotelSearchSort) : SearchIntent
    data class ChangePriceRange(val range: HotelSearchFilter.PriceRange) : SearchIntent

    object ApplyFilter : SearchIntent
    object ResetFilter : SearchIntent
    object ResetUnappliedFilter : SearchIntent

    object Search : SearchIntent
}