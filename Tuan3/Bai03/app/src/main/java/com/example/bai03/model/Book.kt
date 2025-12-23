package com.example.bai03.model

class Book(val id: Int, val name: String) {
    var borrowedBy: User? = null

    fun isBorrowed(): Boolean = borrowedBy != null
}
