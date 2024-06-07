package com.mikhienkov.presentation.booking

import com.mikhienkov.domain.entities.Hotel
import com.mikhienkov.domain.valueobjects.BookingStatus

sealed interface BookingScreenIntent {
    data class ConfirmBookingCanceling(val hotel: Hotel) : BookingScreenIntent
    data class ChangeBookingStatusFiler(val status: BookingStatus) : BookingScreenIntent
    data class CancelBooking(val hotel: Hotel) : BookingScreenIntent
    data object HideBottomSheet : BookingScreenIntent
}