package com.mikhienkov.domain.usecases

import com.mikhienkov.domain.entities.HotelSummary
import com.mikhienkov.domain.repositories.HotelRepository
import com.mikhienkov.utils.Result
import com.mikhienkov.utils.asResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface GetBookmarkedHotelsUseCase {
    operator fun invoke(): Flow<Result<List<HotelSummary>>>
}

class GetBookmarkedHotelsUseCaseImpl @Inject constructor(
    private val hotelRepository: HotelRepository
) : GetBookmarkedHotelsUseCase {
    override fun invoke(): Flow<Result<List<HotelSummary>>> {
        return hotelRepository
            .observeBookmarkedHotelIds()
            .map { hotelIds -> hotelRepository.getHotelsByIds(hotelIds) }
            .map { hotels ->
                hotels.map { hotel -> HotelSummary(hotel = hotel, isBookmarked = true) }
            }
            .asResult()
    }

}