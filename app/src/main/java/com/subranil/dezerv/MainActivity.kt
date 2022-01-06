package com.subranil.dezerv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.subranil.dezerv.adapter.CountryAdapter
import com.subranil.dezerv.api.Api
import com.subranil.dezerv.databinding.ActivityMainBinding
import com.subranil.dezerv.repository.AllocationRepository
import com.subranil.dezerv.viewModel.CountryViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}