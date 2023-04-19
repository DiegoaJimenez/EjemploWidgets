package com.example.ejemplowidgets

import java.io.Serializable

data class TeamInfo(
    val name:String,
    val flag:Int,//referencia un identificador de un recurso (R.id.nombrederecurso)
    val country:String,
    val founded:String,
    val webpage:String,
    val stadiumLocation: String = "geo:53.4308294,-2.9634049z=17"
) : Serializable {

}