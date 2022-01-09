package com.subranil.dezerv.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.subranil.dezerv.R
import com.subranil.dezerv.adapter.CountryAdapter
import com.subranil.dezerv.api.Api
import com.subranil.dezerv.databinding.FragmentHomeBinding
import com.subranil.dezerv.model.Allocation
import com.subranil.dezerv.repository.AllocationRepository
import com.subranil.dezerv.viewModel.CountryViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val countryViewModel by viewModels<CountryViewModel>()
    private lateinit var countryAdapter: CountryAdapter
    private lateinit var actions: NavDirections

    companion object {
        val colorMap = mapOf(
            0 to R.color.teal_200,
            1 to R.color.teal_700,
            2 to R.color.sky_blue,
            3 to R.color.black
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModels()
    }

    private fun setupViewModels() {
        val api = Api()
        val rep = AllocationRepository(api)
        countryViewModel.repository = rep
        countryViewModel.getCountryAllocationData()

        setupAdapter()

        binding.summaryButton.setOnClickListener {
            findNavController().navigate(actions)
        }
    }


    private fun setupAdapter() {
        binding.countryRecyclerView.setHasFixedSize(true)
        val layoutManager = GridLayoutManager(context, 2)
        binding.countryRecyclerView.suppressLayout(true)
        binding.countryRecyclerView.layoutManager = layoutManager
        countryViewModel.countryLiveData.observe(viewLifecycleOwner, {
            countryAdapter = CountryAdapter(it.allocation)
            createView(it.allocation)
            binding.countryRecyclerView.adapter = countryAdapter
            actions = HomeFragmentDirections.actionHomeFragmentToBottomSheetDialog(it.allocation)
        })
    }

    private fun createView(array: Array<Allocation>) {
        array.forEachIndexed { index, allocation ->
            val view = View(context)
            view.layoutParams = ViewGroup.LayoutParams(
                binding.chartLayout.measuredWidth * allocation.percentage.toInt() / 100,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            view.setBackgroundResource(colorMap.getOrDefault(index, 0))
            binding.chartLayout.addView(view)
        }
    }
}