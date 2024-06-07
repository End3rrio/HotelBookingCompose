package com.mikhienkov.presentation.home.recentlybooked

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikhienkov.domain.usecases.BookmarkHotelUseCase
import com.mikhienkov.domain.usecases.GetRecentlyBookedHotelsUseCase
import com.mikhienkov.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecentlyBookedScreenViewModel @Inject constructor(
    private val bookmarkHotel: BookmarkHotelUseCase,
    private val getRecentlyBookedHotels: GetRecentlyBookedHotelsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(RecentlyBookedUiState())
    val state = _state.asStateFlow()

    init {
        collectRecentlyBookedHotels()
    }

    private fun collectRecentlyBookedHotels() {
        viewModelScope.launch {
            _state.update { it.updateIsLoading(true) }
            getRecentlyBookedHotels(limited = false)
                .collect { result ->
                    _state.update { it.updateIsLoading(false) }
                    when (result) {
                        is Result.Error -> _state.update { it.updateHotels(emptyList()) }
                        is Result.Success -> _state.update { it.updateHotels(result.data) }
                    }
                }
        }
    }

    fun handleIntent(intent: RecentlyBookedIntent) = when (intent) {
        is RecentlyBookedIntent.BookmarkHotel -> handleBookmarkHotel(
            intent.hotelId,
            intent.isBookmarked
        )

        is RecentlyBookedIntent.ChangeViewMode -> _state.update { it.updateDisplayMode(intent.hotelDisplayMode) }
    }

    private fun handleBookmarkHotel(hotelId: String, bookmarked: Boolean) {
        viewModelScope.launch {
            bookmarkHotel(hotelId = hotelId, bookmark = !bookmarked)
        }
    }
}