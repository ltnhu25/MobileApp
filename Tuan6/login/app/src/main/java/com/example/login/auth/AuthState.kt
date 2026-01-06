package com.example.login.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object AuthState {

    var message by mutableStateOf("")
    var isSuccess by mutableStateOf<Boolean?>(null)

    fun success(msg: String) {
        isSuccess = true
        message = msg
    }

    fun error(msg: String) {
        isSuccess = false
        message = msg
    }

    fun clear() {
        isSuccess = null
        message = ""
    }
}
