package com.android.weather2022.view.city

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.android.weather2022.databinding.FragmentCityBinding
import com.android.weather2022.network.entity.Weather

class CityFragment: Fragment() {

    lateinit var binding: FragmentCityBinding
    lateinit var adapter: CityAdapter
    lateinit var viewModel: CityViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCityBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(CityViewModel::class.java)
        adapter = CityAdapter(listOf(), object: CityAdapter.MyOnClickListener {
            override fun onClicked(weather: Weather) {
                Log.d("AAA", "tag ${weather.city.name}")
                findNavController().navigate(CityFragmentDirections.actionCityFragmentToMainFragment(weather))
            }
        })
        binding.rvCity.adapter = adapter

        DividerItemDecoration(context, DividerItemDecoration.VERTICAL).also {
            binding.rvCity.addItemDecoration(it)
        }

        viewModel.cityListLiveData.observe(viewLifecycleOwner, Observer { cityList ->
            adapter.setList(cityList)
        })

        viewModel.getCityList()
    }

}