package com.mikhienkov.domain.entities

import com.mikhienkov.domain.valueobjects.BookingStatus

data class BookedHotel(
    val hotel: Hotel,
    val status: BookingStatus
) {
    val address: String = "${hotel.city}, ${hotel.country}"
}
