package com.subranil.dezerv.repository

import com.subranil.dezerv.api.SafeApiRequest
import com.subranil.dezerv.api.Api

class AllocationRepository(private val api: Api) : SafeApiRequest() {
    suspend fun getData() = apiRequest {
        api.getData()
    }
}