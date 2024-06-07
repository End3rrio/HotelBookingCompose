package com.mikhienkov.domain.usecases

import com.mikhienkov.domain.repositories.SearchQueryRepository
import com.mikhienkov.utils.Result
import javax.inject.Inject

interface AddSearchQueryUseCase {
    suspend operator fun invoke(text: String): Result<Unit>
}

class AddSearchQueryUseCaseImpl @Inject constructor(
    private val searchQueryRepository: SearchQueryRepository
) : AddSearchQueryUseCase {
    override suspend fun invoke(text: String): Result<Unit> {
        return try {
            searchQueryRepository.addSearchQuery(text)
            Result.Success(Unit)
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }
}