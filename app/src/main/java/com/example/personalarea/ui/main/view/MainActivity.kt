package com.example.personalarea.ui.main.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.personalarea.R
import com.example.personalarea.data.api.ApiHelper
import com.example.personalarea.data.api.RetrofitBuilder
import com.example.personalarea.ui.base.ViewModelFactory
import com.example.personalarea.ui.main.adapter.TariffRecyclerAdapter
import com.example.personalarea.ui.main.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val factory = ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))

    private lateinit var tariffAdapter: TariffRecyclerAdapter

    private val viewModel by viewModels<MainViewModel>{ factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupObservers()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getTariffs()
    }


    private fun setupUI() {
        val tariffRecyclerView: RecyclerView = findViewById(R.id.tariffList)
        tariffAdapter = TariffRecyclerAdapter()
        tariffRecyclerView.layoutManager = LinearLayoutManager(this)
        tariffRecyclerView.addItemDecoration(
            DividerItemDecoration(
                tariffRecyclerView.context,
                (tariffRecyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        tariffRecyclerView.adapter = tariffAdapter

    }

    private fun setupObservers() {
        viewModel.tariffs.observe(this) {
            tariffAdapter.submitList(it)
        }
    }

}
