package com.mikhienkov.data.api.service

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountriesResponse(
    val data: List<String>
)
