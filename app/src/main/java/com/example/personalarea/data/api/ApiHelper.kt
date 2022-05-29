package com.example.personalarea.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getTariffs() = apiService.getTariffs()
}