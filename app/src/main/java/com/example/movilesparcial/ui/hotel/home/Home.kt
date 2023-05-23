package com.example.movilesparcial.ui.hotel.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio_08.data.model.HotelModel
import com.example.movilesparcial.R
import com.example.movilesparcial.data.adapter.HotelRecyclerAdapter
import com.example.movilesparcial.data.adapter.HotelRecyclerViewHolder
import com.example.movilesparcial.databinding.FragmentHomeBinding
import com.example.movilesparcial.ui.hotel.viewmodel.HotelViewModel

class Home : Fragment() {


    //UI
    private lateinit var recyclerViewHoteles: RecyclerView
    private lateinit var binding : FragmentHomeBinding
    private  lateinit var adapter: HotelRecyclerAdapter
    private val hotelViewModel: HotelViewModel by activityViewModels<HotelViewModel> {
        HotelViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  = FragmentHomeBinding.inflate(inflater, container , false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        bind()
        listeners()
//
//        val adapter = MovieRecylcerViewAdapter()
//        adapter.setData(movieViewModel.getMovies())
//        //adapter.setData(MovieRepository(movies).getMovies())
//
//        recyclerViewMovies.adapter = adapter
//        recyclerViewMovies.layoutManager = LinearLayoutManager(context)

        setRecyclerView(view)

    }

    private fun bind(){
        //cardViewFragmentStarWars = view?.findViewById(R.id.card_view_star_wars) as CardView
        recyclerViewHoteles = view?.findViewById(R.id.recyclerView) as RecyclerView
    }

    private fun listeners(){

        binding.btnLinkNewMovie.setOnClickListener{
            hotelViewModel.clearData()
            it.findNavController().navigate(R.id.action_home2_to_add2)
        }
    }


    private fun showSelectedItem(hotel: HotelModel){
        hotelViewModel.setSelectedHotel(hotel)
        findNavController().navigate(R.id.action_home2_to_descripcion)
    }

    private fun displayMovies(){
        adapter.setData(hotelViewModel.getHoteles())
        adapter.notifyDataSetChanged()
    }
    private fun setRecyclerView(view: View){
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = HotelRecyclerAdapter { selectedHotel ->
            showSelectedItem(selectedHotel)
        }

        binding.recyclerView.adapter = adapter
        displayMovies()
    }


}
