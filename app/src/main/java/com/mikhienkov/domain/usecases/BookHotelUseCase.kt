package com.mikhienkov.domain.usecases

import com.mikhienkov.domain.repositories.HotelRepository
import com.mikhienkov.utils.Result
import javax.inject.Inject

interface BookHotelUseCase {
    suspend operator fun invoke(hotelId: String): Result<Unit>
}

class BookHotelUseCaseImpl @Inject constructor(
    private val hotelRepository: HotelRepository
) : BookHotelUseCase {
    override suspend fun invoke(hotelId: String): Result<Unit> {
        return try {
            hotelRepository.addToBooked(hotelId)
            Result.Success(Unit)
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }
}