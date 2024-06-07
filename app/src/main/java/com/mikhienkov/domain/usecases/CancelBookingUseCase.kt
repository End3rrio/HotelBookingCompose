package com.mikhienkov.domain.usecases

import com.mikhienkov.domain.repositories.HotelRepository
import com.mikhienkov.domain.valueobjects.BookingStatus
import com.mikhienkov.utils.Result
import javax.inject.Inject

interface CancelBookingUseCase {
    suspend operator fun invoke(hotelId: String): Result<Unit>
}

class CancelBookingUseCaseImpl @Inject constructor(
    private val hotelRepository: HotelRepository
) : CancelBookingUseCase {
    override suspend fun invoke(hotelId: String): Result<Unit> {
        return try {
            hotelRepository.updateBookingStatus(hotelId, BookingStatus.CANCELED)
            Result.Success(Unit)
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }

}