package com.mikhienkov.presentation.home

import androidx.compose.runtime.Immutable
import com.mikhienkov.domain.entities.HotelSummary
import com.mikhienkov.domain.valueobjects.HotelCategory


@Immutable
data class HomeUiState(
    val userName: String? = null,
    val hotelCategory: HotelCategory = HotelCategory.Рекомендуемые,
    val hotels: List<HotelSummary> = emptyList(),
    val recentlyBookedHotels: List<HotelSummary> = emptyList(),
    val isHotelByCategoryLoading: Boolean = false,
) {
    fun updateIsHotelByCategoryLoading(value: Boolean) = copy(isHotelByCategoryLoading = value)
    fun updateUserName(value: String?) = copy(userName = value)
    fun updateHotelCategory(value: HotelCategory) = copy(hotelCategory = value)
    fun updateHotels(value: List<HotelSummary>) = copy(hotels = value)
    fun updateRecentlyBookedHotels(value: List<HotelSummary>) = copy(recentlyBookedHotels = value)
}
