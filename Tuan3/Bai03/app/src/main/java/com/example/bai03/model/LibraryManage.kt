package com.example.bai03.model

class LibraryManager {

    val books = mutableListOf<Book>()
    val users = mutableListOf<User>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun addUser(user: User) {
        users.add(user)
    }

    fun borrowBook(book: Book, user: User) {
        if (!book.isBorrowed()) {
            book.borrowedBy = user
        }
    }
}
