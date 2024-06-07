package com.mikhienkov.presentation.hoteldetails

import com.mikhienkov.domain.entities.HotelDetails

sealed interface HotelDetailsUiState {

    data object Loading : HotelDetailsUiState
    data object Error : HotelDetailsUiState
    data class Success(
        val hotelDetails: HotelDetails,
        val isBookmarked: Boolean,
        val isHotelBooked: Boolean = false
    ) : HotelDetailsUiState {
        fun updateIsHotelBooked(value: Boolean) = copy(isHotelBooked = value)
    }
}


