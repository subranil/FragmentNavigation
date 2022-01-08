package com.subranil.dezerv.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Allocation(
    @SerializedName("Name")
    val name: String = "", // India
    @SerializedName("Percentage")
    val percentage: Double = 0.0 // 70.33, val color: kotlin.Int){}
): Parcelable
