package com.mikhienkov.data.api.service

import com.squareup.moshi.JsonClass
import com.mikhienkov.data.api.model.HotelProfile

@JsonClass(generateAdapter = true)
data class HotelsResponse(
    val data: List<HotelProfile>
)
