package com.mikhienkov.presentation.booking

import com.mikhienkov.R
import com.mikhienkov.presentation.designsystem.components.TagState
import com.mikhienkov.domain.valueobjects.BookingStatus

fun BookingStatus.asTagState() = when (this) {
    BookingStatus.ONGOING -> TagState.INFO
    BookingStatus.COMPLETED -> TagState.INFO
    BookingStatus.CANCELED -> TagState.ERROR
}

fun BookingStatus.asStringRes() = when (this) {
    BookingStatus.ONGOING -> R.string.booking_status_ongoing
    BookingStatus.COMPLETED -> R.string.booking_status_completed
    BookingStatus.CANCELED -> R.string.booking_status_canceled
}

fun BookingStatus.asLabelStringRes() = when (this) {
    BookingStatus.ONGOING -> R.string.booking_status_label_ongoing
    BookingStatus.COMPLETED -> R.string.booking_status_label_conpleted
    BookingStatus.CANCELED -> R.string.booking_status_label_canceled
}

fun BookingStatus.asBodyStringRes() = when (this) {
    BookingStatus.ONGOING -> R.string.booking_status_body_ongoing
    BookingStatus.COMPLETED -> R.string.booking_status_body_completed
    BookingStatus.CANCELED -> R.string.booking_status_body_canceled
}