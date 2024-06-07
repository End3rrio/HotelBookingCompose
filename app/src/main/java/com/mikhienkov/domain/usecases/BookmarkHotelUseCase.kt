package com.mikhienkov.domain.usecases

import com.mikhienkov.domain.repositories.HotelRepository
import com.mikhienkov.utils.Result
import javax.inject.Inject

interface BookmarkHotelUseCase {
    suspend operator fun invoke(hotelId: String, bookmark: Boolean): Result<Unit>
}

class BookmarkHotelUseCaseImpl @Inject constructor(
    private val hotelRepository: HotelRepository
) : BookmarkHotelUseCase {
    override suspend fun invoke(hotelId: String, bookmark: Boolean): Result<Unit> {
        return try {
            if (bookmark) {
                hotelRepository.addBookmark(hotelId)
            } else {
                hotelRepository.deleteBookmark(hotelId)
            }
            Result.Success(Unit)
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }

}