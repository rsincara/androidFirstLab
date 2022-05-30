package com.example.personalarea.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.personalarea.data.model.Balance
import com.example.personalarea.data.model.Tariff
import com.example.personalarea.data.model.UserInfo
import com.example.personalarea.data.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    val tariffs = MutableLiveData<List<Tariff>>()
    val balance = MutableLiveData<Balance>()
    val userInfo = MutableLiveData<MutableList<UserInfo>>()

    fun refreshAllData() {
        viewModelScope.launch {
            tariffs.value = mainRepository.getTariffs()
            balance.value = mainRepository.getBalanceList()[0]
            userInfo.value = mainRepository.getUserInfoList().toMutableList()
        }
    }
}