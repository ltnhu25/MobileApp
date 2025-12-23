package com.example.bai02.payment

interface PaymentMethod {
    fun getName(): String
    fun pay(amount: Double): Boolean
}
