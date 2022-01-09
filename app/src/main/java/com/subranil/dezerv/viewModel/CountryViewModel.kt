package com.subranil.dezerv.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.subranil.dezerv.api.ApiException
import com.subranil.dezerv.model.Allocation
import com.subranil.dezerv.model.ModelData
import com.subranil.dezerv.repository.AllocationRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CountryViewModel(application: Application) : AndroidViewModel(application) {
    var repository: AllocationRepository? = null
    private val _countryLiveData: MutableLiveData<ModelData> = MutableLiveData()
    val countryLiveData: LiveData<ModelData> = _countryLiveData

    fun getCountryAllocationData() {
        viewModelScope.launch {
            // {"status": 1, "message": "you have exceeded the call limit (10000)"}
//            {"Allocation": [ { "Name": "India", "Percentage": 70.33 }, { "Name": "America", "Percentage": 14.64 }, { "Name": "Japan", "Percentage": 10.05 }, { "Name": "China", "Percentage": 4.98 }]}
            delay(1000)
            try {
                _countryLiveData.value = repository?.getData()
            } catch (exception: ApiException) {
                Log.d("", exception.toString())
                _countryLiveData.value = ModelData(
                    allocation = arrayOf(
                        Allocation(name = "India", percentage = 70.33),
                        Allocation(name = "America", percentage = 14.64),
                        Allocation(name = "Japan", percentage = 10.05),
                        Allocation(name = "China", percentage = 4.98)
                    )
                )
            }
        }
    }
}