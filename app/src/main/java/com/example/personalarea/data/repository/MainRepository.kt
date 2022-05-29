package com.example.personalarea.data.repository

import com.example.personalarea.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getTariffs() = apiHelper.getTariffs()
}