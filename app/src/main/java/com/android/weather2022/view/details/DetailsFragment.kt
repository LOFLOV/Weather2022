package com.android.weather2022.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.weather2022.databinding.FragmentDetailsBinding
import com.android.weather2022.extensions.switchVisibility
import com.android.weather2022.network.entity.Weather

class DetailsFragment : Fragment() {

    lateinit var binding: FragmentDetailsBinding
    lateinit var viewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)

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