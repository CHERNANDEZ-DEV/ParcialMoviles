package com.example.movilesparcial.ui.hotel.add

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.movilesparcial.R
import com.example.movilesparcial.databinding.FragmentAddBinding
import com.example.movilesparcial.ui.hotel.viewmodel.HotelViewModel

class Add : Fragment() {

    private lateinit var binding : FragmentAddBinding

    private val hotelViewModel: HotelViewModel by activityViewModels<HotelViewModel> {
        HotelViewModel.Factory
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hotelViewModel.SetNewMovieFragment()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  = FragmentAddBinding.inflate(inflater, container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observerStatus()
    }


    private fun setViewModel(){
        binding.viewmodel = hotelViewModel
    }

    private fun observerStatus(){
        hotelViewModel.status.observe(viewLifecycleOwner){
            when{
                it.equals(HotelViewModel.WRONG_INFORMATION)->{
                    Log.d("APP_TAG", it)
                    hotelViewModel.clearStatus()
                }
                it.equals(HotelViewModel.HOTEL_CREATED)->{
                    Log.d("APP_TAG", it)
                    Log.d("APP_TAG", hotelViewModel.getHoteles().toString())

                    hotelViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

}