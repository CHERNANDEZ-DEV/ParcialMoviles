package com.example.movilesparcial.ui.hotel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.movilesparcial.R
import com.example.movilesparcial.databinding.FragmentDescripcionBinding
import com.example.movilesparcial.ui.hotel.viewmodel.HotelViewModel

class Descripcion : Fragment() {

    private val hotelViewModel: HotelViewModel by activityViewModels {
        HotelViewModel.Factory
    }
    private lateinit var binding : FragmentDescripcionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        hotelViewModel.SetMovieFragment()


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  = FragmentDescripcionBinding.inflate(inflater, container , false)
        return binding.root
    }

    private fun setViewModel(){
        binding.viewmodel = hotelViewModel
    }
}