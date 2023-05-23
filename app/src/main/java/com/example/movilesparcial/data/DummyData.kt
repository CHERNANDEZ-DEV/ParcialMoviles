import com.example.laboratorio_08.data.model.HotelModel

//model 01
const val nombre = "Decameron"
const val ubicacion = "La Libertad"


//model 02
const val nombre2 = "Salinitas"
const val ubicacion2 = "San Salvador"


var hoteles = mutableListOf(
    HotelModel(nombre, ubicacion),
    HotelModel(nombre2, ubicacion2),
)