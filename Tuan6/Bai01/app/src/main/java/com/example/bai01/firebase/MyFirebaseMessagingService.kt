package com.example.bai01.firebase

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.util.Log

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        Log.d("FCM", "From: ${message.from}")
        Log.d("FCM", "Title: ${message.notification?.title}")
    }
}
