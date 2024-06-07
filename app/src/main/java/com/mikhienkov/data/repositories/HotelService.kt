package com.mikhienkov.data.repositories

import com.mikhienkov.domain.entities.Hotel
import com.mikhienkov.domain.entities.HotelDetails
import com.mikhienkov.domain.valueobjects.HotelCategory
import com.mikhienkov.domain.valueobjects.HotelSearchFilter

interface HotelService {
    suspend fun searchHotels(categories: List<HotelCategory>): List<Hotel>
    suspend fun getHotelsByIds(ids: List<String>): List<Hotel>
    suspend fun getHotelDetails(hotelId: String): HotelDetails
    suspend fun searchHotelsWithFilter(
        query: String,
        categories: List<HotelCategory>,
        filter: HotelSearchFilter
    ): List<Hotel>

    suspend fun getCountries(): List<String>
}