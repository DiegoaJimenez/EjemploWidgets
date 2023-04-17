package com.example.ejemplowidgets

import java.io.Serializable

data class TeamInfo(
    val name:String,
    val flag:Int,//referencia un identificador de un recurso (R.id.nombrederecurso)
    val country:String,
    val founded:String
) : Serializable {

}