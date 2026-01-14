package com.example.bai01.firebase

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics

object AnalyticsManager {

    fun logLogin(context: Context) {
        val analytics = FirebaseAnalytics.getInstance(context)
        analytics.logEvent("login_success", null)
    }
}
