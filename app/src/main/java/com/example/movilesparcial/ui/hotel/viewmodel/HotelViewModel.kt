package com.example.movilesparcial.ui.hotel.viewmodel

import HotelRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.laboratorio_08.data.model.HotelModel
import com.example.movilesparcial.ui.hotel.HotelReviewerApplication

class HotelViewModel (private val repository: HotelRepository): ViewModel() {
    val nombre = MutableLiveData("")
    val ubicacion = MutableLiveData("")

    //logical on back
    private var screenNumber: Int = 0

    fun getScreenFragment()= screenNumber

    fun SetNewMovieFragment () {
        screenNumber = 2
    }

    fun SetMovieFragment() {
        screenNumber = 1
    }
    fun SetBillboardFragment() {
        screenNumber = 0
    }

    fun getHoteles() = repository.getHoteles()

    private fun addHotel (hotel: HotelModel) = repository.setHoteles(hotel)

    fun createHotel(){
        if(!validateData()){
           // status.value = WRONG_INFORMATION
            return
        }
        val hotel = HotelModel(
            nombre.value!!,
            ubicacion.value!!
            )
        addHotel(hotel)
        clearData()

        //status.value = MOVIE_CREATED
    }

    private fun validateData(): Boolean{
        when{
            nombre.value.isNullOrBlank() -> return false
            ubicacion.value.isNullOrBlank() -> return false
        }
        return true
    }

    fun clearData(){
        nombre.value = ""
        ubicacion.value = ""
    }
    fun clearStatus(){
        //status.value = INACTIVE
    }

    fun setSelectedHotel(hotel: HotelModel){
        nombre.value = hotel.nombre
        ubicacion.value = hotel.ubicacion
    }
    companion object{
        val Factory = viewModelFactory {
            initializer {
                val hotelRepositoryApp = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as HotelReviewerApplication).hotelRepository

                HotelViewModel(hotelRepositoryApp)
            }
        }
        const val HOTEL_CREATED = "Hotel created"
        const val  WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""

    }
}