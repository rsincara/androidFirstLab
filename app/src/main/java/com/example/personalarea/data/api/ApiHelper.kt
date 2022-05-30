package com.example.personalarea.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getTariffs() = apiService.getTariffs()
    suspend fun getBalanceList() = apiService.getBalanceList()
    suspend fun getUserInfoList() = apiService.getUserInfoList()
}