package com.mikhienkov.data.database.hotel.model

import com.mikhienkov.domain.valueobjects.BookingStatus

data class BookingDocument(
    val hotelId: String = "",
    val status: BookingStatus = BookingStatus.ONGOING
//    val name: String,
//    val guests: Int,
//    val checkIn: String,
//    val checkOut: String
)
