package com.example.myapplication.network.model

data class ApiResponse(
    val results: List<Character>?
)

data class Character(
    val id: Int?,
    val name: String?,
    val image: String?
)
