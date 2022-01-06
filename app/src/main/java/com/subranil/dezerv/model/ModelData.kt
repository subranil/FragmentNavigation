package com.subranil.dezerv.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelData(
    @SerializedName("Allocation")
    val allocation: Array<Allocation> = arrayOf()
): Parcelable