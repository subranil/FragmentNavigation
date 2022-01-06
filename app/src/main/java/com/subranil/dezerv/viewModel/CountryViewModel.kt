package com.subranil.dezerv.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.subranil.dezerv.model.ModelData
import com.subranil.dezerv.repository.AllocationRepository
import kotlinx.coroutines.launch

class CountryViewModel(application: Application) : AndroidViewModel(application) {
    var repository: AllocationRepository? = null
    private val _countryLiveData: MutableLiveData<ModelData> = MutableLiveData()
    val countryLiveData: LiveData<ModelData> = _countryLiveData

    fun getCountryAllocationData() {
        viewModelScope.launch {
           _countryLiveData.value = repository?.getData()
        }
    }
}