package com.example.bai01.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object List : Screen("list")
    object Text : Screen("text")
    object Image : Screen("image")
    object TextField : Screen("textfield")
    object Layout : Screen("layout")
    object Custom : Screen("custom")
}
