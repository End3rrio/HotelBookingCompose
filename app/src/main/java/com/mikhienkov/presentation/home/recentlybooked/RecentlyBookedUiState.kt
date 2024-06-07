package com.mikhienkov.presentation.home.recentlybooked

import com.mikhienkov.designsystem.components.HotelDisplayMode
import com.mikhienkov.domain.entities.HotelSummary

data class RecentlyBookedUiState(
    val isLoading: Boolean = true,
    val hotelDisplayMode: HotelDisplayMode = HotelDisplayMode.LIST,
    val hotels: List<HotelSummary> = emptyList()
) {

    fun updateIsLoading(value: Boolean) = copy(isLoading = value)
    fun updateDisplayMode(value: HotelDisplayMode) = copy(hotelDisplayMode = value)
    fun updateHotels(value: List<HotelSummary>) = copy(hotels = value)
}
