package com.subranil.dezerv.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.subranil.dezerv.R
import com.subranil.dezerv.databinding.CountryDataBinding
import com.subranil.dezerv.fragment.HomeFragment
import com.subranil.dezerv.model.Allocation

class CountryAdapter(private var countryList: Array<Allocation>) :
    RecyclerView.Adapter<CountryAdapter.CustomViewHolder>() {

    inner class CustomViewHolder(dataBinding: CountryDataBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {

        var countryData: TextView = dataBinding.countryName
        var countryPercentage: TextView = dataBinding.countryPercentage
        var color = dataBinding.countryColor

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
            CountryDataBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val countryList = countryList
        holder.countryData.text = countryList[position].name
        holder.countryPercentage.text = "${countryList[position].percentage } %"
        holder.color.setBackgroundResource(HomeFragment.colorMap.getOrDefault(position, R.color.design_default_color_primary))
    }

    override fun getItemCount(): Int {
        return countryList.size
    }
}