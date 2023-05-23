
import com.example.laboratorio_08.data.model.HotelModel

class HotelRepository (private  val hoteles: MutableList<HotelModel>){
    fun getHoteles () = hoteles

    fun setHoteles (hotel: HotelModel) = hoteles.add(hotel)
}