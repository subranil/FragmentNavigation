package com.subranil.dezerv.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.subranil.dezerv.R
import com.subranil.dezerv.adapter.CountryAdapter
import com.subranil.dezerv.databinding.FragmentBottomSheetDialogBinding

class BottomSheetDialog : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentBottomSheetDialogBinding
    private val args by navArgs<BottomSheetDialogArgs>()
    private lateinit var countryAdapter: CountryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentBottomSheetDialogBinding.inflate(layoutInflater, container, false)
        setUpAdapter()
        return binding.root
    }

    private fun setUpAdapter() {
        val layoutManager = GridLayoutManager(context, 2)
        binding.bottomSheetRecyclerView.layoutManager = layoutManager
        val list = args.allocationData
        countryAdapter = CountryAdapter(list)
        binding.bottomSheetRecyclerView.adapter = countryAdapter
    }
}