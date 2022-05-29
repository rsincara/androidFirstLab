package com.example.personalarea.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.personalarea.data.model.Tariff
import com.example.personalarea.data.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    val tariffs = MutableLiveData<List<Tariff>>()

    fun getTariffs() {
        viewModelScope.launch {
            tariffs.value = mainRepository.getTariffs()
        }
    }
}