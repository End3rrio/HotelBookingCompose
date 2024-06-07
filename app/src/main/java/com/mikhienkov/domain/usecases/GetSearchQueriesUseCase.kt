package com.mikhienkov.domain.usecases

import com.mikhienkov.domain.entities.SearchQuery
import com.mikhienkov.domain.repositories.SearchQueryRepository
import com.mikhienkov.utils.Result
import com.mikhienkov.utils.asResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetSearchQueriesUseCase {
    operator fun invoke(): Flow<Result<List<SearchQuery>>>
}

class GetSearchQueriesUseCaseImpl @Inject constructor(
    private val searchQueryRepository: SearchQueryRepository
) : GetSearchQueriesUseCase {
    override fun invoke(): Flow<Result<List<SearchQuery>>> {
        return searchQueryRepository.getSearchQueries().asResult()
    }
}