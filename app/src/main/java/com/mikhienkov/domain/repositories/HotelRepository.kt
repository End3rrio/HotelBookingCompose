package com.mikhienkov.domain.repositories

import com.mikhienkov.domain.entities.BookedHotel
import com.mikhienkov.domain.entities.Hotel
import com.mikhienkov.domain.entities.HotelDetails
import com.mikhienkov.domain.valueobjects.BookingStatus
import com.mikhienkov.domain.valueobjects.HotelCategory
import com.mikhienkov.domain.valueobjects.HotelSearchFilter
import kotlinx.coroutines.flow.Flow

interface HotelRepository {
    suspend fun getHotelsByIds(ids: List<String>): List<Hotel>
    suspend fun getHotelsByCategories(
        categories: List<HotelCategory>,
        limit: Int = Int.MAX_VALUE
    ): List<Hotel>

    suspend fun searchHotelsWithFilter(
        query: String,
        categories: List<HotelCategory>,
        filter: HotelSearchFilter
    ): List<Hotel>


    fun getBookedHotels(): Flow<List<BookedHotel>>
    suspend fun addBookmark(hotelId: String)
    suspend fun deleteBookmark(hotelId: String)
    suspend fun addToBooked(hotelId: String)
    suspend fun deleteFromBooked(hotelId: String)
    fun observeBookmarkedHotelIds(): Flow<List<String>>
    suspend fun getCountries(): List<String>
    suspend fun getHotelDetails(hotelId: String): HotelDetails
    suspend fun getHotelImages(hotelId: String): List<String>
    suspend fun updateBookingStatus(hotelId: String, status: BookingStatus)
}