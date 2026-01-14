package com.example.bai01.firebase

import android.net.Uri
import com.google.firebase.storage.FirebaseStorage

object StorageManager {

    private val storage = FirebaseStorage.getInstance()

    fun uploadAvatar(uid: String, uri: Uri, onDone: (String) -> Unit) {
        val ref = storage.reference.child("avatars/$uid.jpg")
        ref.putFile(uri).addOnSuccessListener {
            ref.downloadUrl.addOnSuccessListener { url ->
                onDone(url.toString())
            }
        }
    }
}
