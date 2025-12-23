package com.example.bai02.payment

class PaymentManager {

    private var paymentMethod: PaymentMethod? = null

    fun setPaymentMethod(method: PaymentMethod) {
        paymentMethod = method
    }

    fun processPayment(amount: Double): Boolean {
        return paymentMethod?.pay(amount) ?: false
    }
}
