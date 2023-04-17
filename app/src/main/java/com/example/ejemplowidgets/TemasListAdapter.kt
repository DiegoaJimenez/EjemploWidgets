package com.example.ejemplowidgets

import android.text.Layout
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class TemasListAdapter(val ctx: MainActivity,val layout:Int,val data: List<String>)
    :ArrayAdapter<String>(ctx,layout,data){

    //Este elemento se llama por cada elemento del arreglo de datos
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val container = ctx.layoutInflater.inflate(layout,null)
        //cambiar el nombre del equipo para este elemento en la lista
        val teamName = container.findViewById<TextView>(R.id.teamName)
        teamName.text = data[position]

        //cambiar la imagen para este elemento de la lista
        val id = ctx.resources.getIdentifier(data[position].lowercase(),"drawable",ctx.packageName)
        val teamIcon = container.findViewById<ImageView>(R.id.teamicon)
        teamIcon.setImageResource(id)
        return container
    }
}