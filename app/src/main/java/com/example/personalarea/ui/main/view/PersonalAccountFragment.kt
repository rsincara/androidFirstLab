package com.example.personalarea.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.personalarea.R
import com.example.personalarea.data.api.ApiHelper
import com.example.personalarea.data.api.RetrofitBuilder
import com.example.personalarea.data.model.Balance
import com.example.personalarea.ui.base.ViewModelFactory
import com.example.personalarea.ui.main.viewmodel.MainViewModel


class PersonalAccountFragment : Fragment() {
    private val factory = ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
    private val viewModel by viewModels<MainViewModel>{ factory }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.personal_account_fragment, container, false)
        val personalAccountNumber: TextView = rootView.findViewById(R.id.personalAccountNumber)
        val balance: TextView = rootView.findViewById(R.id.balance)
        val sumToPay: TextView = rootView.findViewById(R.id.sumToPay)

        viewModel.refreshAllData()
        setupObservers(personalAccountNumber, balance, sumToPay)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    private fun setupObservers(personalAccountNumber: TextView, balance: TextView, sumToPay: TextView ) {

        viewModel.balance.observe(viewLifecycleOwner){
            personalAccountNumber.text = it.accNum.toString()
            balance.text = it.balance.toString()
            sumToPay.text = it.nextPay.toString()
        }
    }

}