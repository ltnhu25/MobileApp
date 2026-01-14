package com.example.bai01.firebase

import com.example.bai01.model.UserProfile
import com.google.firebase.firestore.FirebaseFirestore

object FirestoreManager {

    private val db = FirebaseFirestore.getInstance()

    fun saveUser(profile: UserProfile) {
        db.collection("users")
            .document(profile.uid)
            .set(profile)
    }
}
