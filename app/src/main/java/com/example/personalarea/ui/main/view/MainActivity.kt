package com.example.personalarea.ui.main.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.personalarea.R
import com.example.personalarea.data.api.ApiHelper
import com.example.personalarea.data.api.RetrofitBuilder
import com.example.personalarea.ui.base.ViewModelFactory
import com.example.personalarea.ui.main.viewmodel.MainViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.personalarea.data.model.Tariff
import com.example.personalarea.ui.main.adapter.TariffRecyclerAdapter
import com.example.personalarea.utils.Status

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var tariffAdapter: TariffRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupUI()
        setupObservers()
    }


    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupUI() {
        val tariffRecyclerView: RecyclerView = findViewById(R.id.tariffList)

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
        val tariffRecyclerView: RecyclerView = findViewById(R.id.tariffList)

        viewModel.getTariffs().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        tariffRecyclerView.visibility = View.VISIBLE
                        resource.data?.let { users -> retrieveList(users) }
                    }
                    Status.ERROR -> {
                        tariffRecyclerView.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    private fun retrieveList(users: List<Tariff>) {
        tariffAdapter.apply {
            addUsers(users)
            notifyDataSetChanged()
        }
    }
}
