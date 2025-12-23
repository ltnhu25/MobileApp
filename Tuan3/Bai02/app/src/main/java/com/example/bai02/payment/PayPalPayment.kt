package com.example.bai02.payment

class PayPalPayment : PaymentMethod {
    override fun getName() = "PayPal"

    override fun pay(amount: Double): Boolean {
        println("Thanh toán $amount bằng PayPal")
        return true
    }
}
