package com.example.bai02.payment

import com.example.bai02.R

enum class PaymentType(
    val displayName: String,
    val logoRes: Int
) {
    PAYPAL("PayPal", R.drawable.logo_paypal),
    GOOGLE_PAY("GooglePay", R.drawable.logo_googlepay),
    APPLE_PAY("ApplePay", R.drawable.logo_applepay)
}
