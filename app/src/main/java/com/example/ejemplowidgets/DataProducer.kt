package com.example.ejemplowidgets

class DataProducer {

    val teamNames = arrayListOf<String>("Liverpool","Realmadrid","Chelsea","Atletico de Madrid","Millonarios")

    fun GetTeamNames(): List<String> {
        return teamNames
    }
}