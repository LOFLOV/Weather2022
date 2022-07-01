package com.android.weather2022.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.android.weather2022.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            tvCityName.text = args.navDeteilsArg.city.name
            tvDegree.text = "${args.navDeteilsArg.temperature}'C"
            tvFeelsLike.text = "feels like:${args.navDeteilsArg.feelsLike}'C"
            tvCountryCode.text = "${args.navDeteilsArg.city.lat} / ${args.navDeteilsArg.city.lon}"
        }
    }
}
