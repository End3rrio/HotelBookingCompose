package com.mikhienkov.presentation.home.recentlybooked

import com.mikhienkov.presentation.designsystem.components.HotelDisplayMode


sealed interface RecentlyBookedIntent {
    data class ChangeViewMode(val hotelDisplayMode: HotelDisplayMode) : RecentlyBookedIntent
    data class BookmarkHotel(val hotelId: String, val isBookmarked: Boolean) : RecentlyBookedIntent
}