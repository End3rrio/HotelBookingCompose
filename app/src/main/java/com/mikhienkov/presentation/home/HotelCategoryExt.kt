package com.mikhienkov.presentation.home

import com.mikhienkov.R
import com.mikhienkov.domain.valueobjects.HotelCategory

val HotelCategory.stringResId
    get() = when (this) {
        HotelCategory.Популярные -> R.string.hotel_category_Популярные
        HotelCategory.Рекомендуемые -> R.string.hotel_category_Рекомендуемые
        HotelCategory.Новые -> R.string.hotel_category_Новые
    }