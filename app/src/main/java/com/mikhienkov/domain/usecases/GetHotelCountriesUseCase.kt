package com.mikhienkov.domain.usecases

import com.mikhienkov.domain.repositories.HotelRepository
import com.mikhienkov.utils.Result
import javax.inject.Inject

interface GetHotelCountriesUseCase {
    suspend operator fun invoke(): Result<List<String>>
}

class GetHotelCountriesUseCaseImpl @Inject constructor(
    private val hotelRepository: HotelRepository
) : GetHotelCountriesUseCase {
    override suspend fun invoke(): Result<List<String>> {
        return try {
            val countries = hotelRepository.getCountries()
            Result.Success(countries)
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }
}