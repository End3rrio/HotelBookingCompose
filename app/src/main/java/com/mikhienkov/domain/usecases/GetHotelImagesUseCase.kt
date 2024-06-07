package com.mikhienkov.domain.usecases

import com.mikhienkov.domain.repositories.HotelRepository
import com.mikhienkov.utils.Result
import javax.inject.Inject

interface GetHotelImagesUseCase {
    suspend operator fun invoke(hotelId: String): Result<List<String>>
}

class GetHotelImagesUseCaseImpl @Inject constructor(
    private val hotelRepository: HotelRepository
) : GetHotelImagesUseCase {
    override suspend fun invoke(hotelId: String): Result<List<String>> {
        return try {
            val imageUrls = hotelRepository.getHotelImages(hotelId)
            Result.Success(imageUrls)
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }
}