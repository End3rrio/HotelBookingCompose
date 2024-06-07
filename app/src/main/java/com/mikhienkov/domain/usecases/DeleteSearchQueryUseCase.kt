package com.mikhienkov.domain.usecases

import com.mikhienkov.domain.repositories.SearchQueryRepository
import com.mikhienkov.utils.Result
import javax.inject.Inject

interface DeleteSearchQueryUseCase {
    suspend operator fun invoke(id: String): Result<Unit>
}

class DeleteSearchQueryUseCaseImpl @Inject constructor(
    private val searchQueryRepository: SearchQueryRepository
) : DeleteSearchQueryUseCase {
    override suspend fun invoke(id: String): Result<Unit> {
        return try {
            searchQueryRepository.deleteSearchQuery(id)
            Result.Success(Unit)
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }
}