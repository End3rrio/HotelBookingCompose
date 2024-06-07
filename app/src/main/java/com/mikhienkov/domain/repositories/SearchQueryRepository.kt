package com.mikhienkov.domain.repositories

import com.mikhienkov.domain.entities.SearchQuery
import kotlinx.coroutines.flow.Flow

interface SearchQueryRepository {
    fun getSearchQueries(): Flow<List<SearchQuery>>
    suspend fun deleteSearchQuery(id: String)
    suspend fun addSearchQuery(query: String)
}