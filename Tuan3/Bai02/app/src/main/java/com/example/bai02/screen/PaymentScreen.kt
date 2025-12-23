package com.example.bai02.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bai02.R
import com.example.bai02.component.PaymentItem
import com.example.bai02.payment.*

@Composable
fun PaymentScreen() {

    val context = LocalContext.current
    val paymentManager = remember { PaymentManager() }

    var selectedType by remember { mutableStateOf<PaymentType?>(null) }

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // LOGO
            Image(
                painter = painterResource(
                    id = selectedType?.logoRes ?: R.drawable.ic_wallet
                ),
                contentDescription = null,
                modifier = Modifier
                    .height(160.dp)
                    .padding(bottom = 40.dp)
            )

            Divider()

            Spacer(modifier = Modifier.height(16.dp))

            PaymentItem(
                name = "PayPal",
                logoRes = R.drawable.logo_paypal,
                isSelected = selectedType == PaymentType.PAYPAL
            ) {
                selectedType = PaymentType.PAYPAL
                paymentManager.setPaymentMethod(PayPalPayment())
            }

            PaymentItem(
                name = "GooglePay",
                logoRes = R.drawable.logo_googlepay,
                isSelected = selectedType == PaymentType.GOOGLE_PAY
            ) {
                selectedType = PaymentType.GOOGLE_PAY
                paymentManager.setPaymentMethod(GooglePayPayment())
            }

            PaymentItem(
                name = "ApplePay",
                logoRes = R.drawable.logo_applepay,
                isSelected = selectedType == PaymentType.APPLE_PAY
            ) {
                selectedType = PaymentType.APPLE_PAY
                paymentManager.setPaymentMethod(ApplePayPayment())
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    paymentManager.processPayment(100.0)
                    Toast.makeText(
                        context,
                        "Thanh toán thành công",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                enabled = selectedType != null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text("Continue")
            }
        }
    }
}
