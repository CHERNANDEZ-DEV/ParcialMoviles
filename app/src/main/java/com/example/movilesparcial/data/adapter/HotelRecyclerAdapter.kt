package com.example.movilesparcial.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio_08.data.model.HotelModel
import com.example.movilesparcial.databinding.FragmentItemBinding
import java.util.ArrayList

class HotelRecyclerAdapter(
    private val clickListener: (HotelModel)-> Unit
): RecyclerView.Adapter<HotelRecyclerViewHolder>() {
    private val hoteles = ArrayList<HotelModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelRecyclerViewHolder {
        val binding = FragmentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HotelRecyclerViewHolder(binding)
    }

    override fun getItemCount()= hoteles.size

    override fun onBindViewHolder(holder: HotelRecyclerViewHolder, position: Int) {
        val movie = hoteles[position]
        holder.bind(movie, clickListener)
    }

    fun setData(moviesList: List<HotelModel>){
        hoteles.clear()
        hoteles.addAll(moviesList)
    }

}