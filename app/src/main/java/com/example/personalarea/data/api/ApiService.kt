package com.example.personalarea.data.api

import com.example.personalarea.data.model.Balance
import com.example.personalarea.data.model.Tariff
import com.example.personalarea.data.model.UserInfo
import retrofit2.http.GET

interface ApiService {
    @GET("tariffs")
    suspend fun getTariffs(): List<Tariff>

    @GET("balance")
    suspend fun getBalanceList(): List<Balance>

    @GET("userInfo")
    suspend fun getUserInfoList(): List<UserInfo>
}