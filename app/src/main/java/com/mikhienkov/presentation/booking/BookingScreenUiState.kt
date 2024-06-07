package com.mikhienkov.presentation.booking

import com.mikhienkov.domain.entities.BookedHotel
import com.mikhienkov.domain.entities.Hotel
import com.mikhienkov.domain.valueobjects.BookingStatus

data class BookingScreenUiState(
    val isLoading: Boolean = false,
    val hotels: List<BookedHotel> = emptyList(),
    val bookingStatusFilter: BookingStatus = BookingStatus.ONGOING,
    val hotelToCancel: Hotel? = null
) {
    val hotelsToDisplay
        get() = hotels.filter { it.status == bookingStatusFilter }

    fun updateIsLoading(value: Boolean) = copy(isLoading = value)

    fun updateHotels(value: List<BookedHotel>) = copy(hotels = value)

    fun updateBookingStatusFilter(value: BookingStatus) = copy(bookingStatusFilter = value)

    fun updateHotelToCancel(value: Hotel?) = copy(hotelToCancel = value)
}
