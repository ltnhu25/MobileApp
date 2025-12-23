package com.example.bai02.payment

class ApplePayPayment : PaymentMethod {
    override fun getName() = "Apple Pay"

    override fun pay(amount: Double): Boolean {
        println("Thanh toán $amount bằng Apple Pay")
        return true
    }
}
