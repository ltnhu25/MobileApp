package com.example.bai02.payment

class GooglePayPayment : PaymentMethod {
    override fun getName() = "Google Pay"

    override fun pay(amount: Double): Boolean {
        println("Thanh toán $amount bằng Google Pay")
        return true
    }
}
