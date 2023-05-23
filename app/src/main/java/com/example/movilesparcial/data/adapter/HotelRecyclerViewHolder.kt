package com.example.movilesparcial.data.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio_08.data.model.HotelModel
import com.example.movilesparcial.databinding.FragmentItemBinding

class HotelRecyclerViewHolder(private val binding: FragmentItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(hotel : HotelModel, clickListener: (HotelModel) -> Unit){
        binding.textViewName.text = hotel.nombre
        binding.textViewQualification.text = hotel.ubicacion

        binding.cardViewMovie.setOnClickListener{
            clickListener(hotel)
        }
    }
}