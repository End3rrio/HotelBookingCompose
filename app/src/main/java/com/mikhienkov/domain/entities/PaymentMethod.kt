package com.mikhienkov.domain.entities

sealed interface PaymentMethod {
    data object Paypal : PaymentMethod
    data object GooglePay : PaymentMethod
    data class Card(val number: String) : PaymentMethod
}