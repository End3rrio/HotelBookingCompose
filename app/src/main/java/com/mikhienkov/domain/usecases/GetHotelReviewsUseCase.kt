package com.mikhienkov.domain.usecases

import com.mikhienkov.domain.entities.HotelDetails
import com.mikhienkov.domain.repositories.HotelRepository
import com.mikhienkov.utils.Result
import javax.inject.Inject

interface GetHotelReviewsUseCase {
    data class HotelReviews(
        val numberOfReviews: Int,
        val averageRating: Double,
        val reviews: List<HotelDetails.Review>
    )

    suspend operator fun invoke(hotelId: String): Result<HotelReviews>
}

class GetHotelReviewsUseCaseImpl @Inject constructor(
    private val hotelRepository: HotelRepository
) : GetHotelReviewsUseCase {
    override suspend fun invoke(hotelId: String): Result<GetHotelReviewsUseCase.HotelReviews> {
        return try {
            val hotelDetails = hotelRepository.getHotelDetails(hotelId)
            val reviews = hotelDetails.reviews
            val averageRating = hotelDetails.hotel.rating
            val numberOfReviews = reviews.size
            Result.Success(
                GetHotelReviewsUseCase.HotelReviews(
                    numberOfReviews = numberOfReviews,
                    averageRating = averageRating,
                    reviews = reviews
                )
            )
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }
}

