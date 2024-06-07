package com.mikhienkov.domain.usecases

import com.mikhienkov.domain.entities.BookedHotel
import com.mikhienkov.domain.repositories.HotelRepository
import com.mikhienkov.utils.Result
import com.mikhienkov.utils.asResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetBookedHotelsUseCase {
    operator fun invoke(): Flow<Result<List<BookedHotel>>>
}

class GetBookedHotelsUseCaseImpl @Inject constructor(
    private val hotelRepository: HotelRepository
) : GetBookedHotelsUseCase {
    override fun invoke(): Flow<Result<List<BookedHotel>>> {
        return hotelRepository.getBookedHotels().asResult()
    }
}