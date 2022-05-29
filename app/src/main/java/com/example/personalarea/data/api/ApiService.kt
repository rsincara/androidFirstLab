package com.example.personalarea.data.api

import com.example.personalarea.data.model.Tariff
import retrofit2.http.GET

interface ApiService {
    @GET("tariffs")
    suspend fun getTariffs(): List<Tariff>
}