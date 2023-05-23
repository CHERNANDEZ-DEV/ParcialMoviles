package com.example.movilesparcial.ui.hotel

import HotelRepository
import android.app.Application
import hoteles

class HotelReviewerApplication : Application() {
    val hotelRepository : HotelRepository by lazy {
        HotelRepository(hoteles)
    }
}