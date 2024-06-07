package com.mikhienkov.presentation.hoteldetails.gallery

sealed interface GalleryIntent {
    data class OpenImage(val url: String) : GalleryIntent
    data object CloseImage : GalleryIntent
}