package com.android.weather2022.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.weather2022.network.entity.Weather
import com.android.weather2022.databinding.FragmentMainBinding
import com.android.weather2022.extensions.switchVisibility

class HomeFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        viewModel.weatherLiveData.observe(viewLifecycleOwner, object: Observer<Weather> {
            override fun onChanged(weather: Weather) {
                binding.tvCityName.text = weather.city.name
                binding.tvDegree.text = weather.temperature.toString()
            }
        })
        viewModel.errorLiveData.observe(viewLifecycleOwner, Observer { error ->
            binding.tvError.switchVisibility(error)
        })
        viewModel.getWeatherData()
    }
}