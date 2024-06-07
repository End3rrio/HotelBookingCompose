package com.mikhienkov.data.database.searchquery

import com.mikhienkov.domain.entities.SearchQuery

data class SearchQueryDocument(
    val id: String = "",
    val text: String = ""
) {
    fun toDomain() = SearchQuery(id = id, text = text)

    companion object {
        fun fromDomain(domain: SearchQuery) = SearchQueryDocument(
            id = domain.id,
            text = domain.text
        )
    }
}
