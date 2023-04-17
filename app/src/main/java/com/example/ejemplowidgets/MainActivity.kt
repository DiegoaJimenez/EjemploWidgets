package com.example.ejemplowidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.ejemplowidgets.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    val teamNames = arrayListOf<String>("Liverpool","Realmadrid","Chelsea","Atletico de Madrid")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imgTeam.setImageResource(R.drawable.realmadrid)

        binding.btnLiverpool.setOnClickListener { changeTeam("liverpool") }
        binding.btnRealmadrid.setOnClickListener { changeTeam("realmadrid") }

        binding.rdbtnliverpool.setOnClickListener { changeTeam("liverpool") }
        binding.rdbtnrealmadrid.setOnClickListener { changeTeam("realmadrid") }

        binding.swtTeam.setOnClickListener {
            if(binding.swtTeam.isChecked)
                changeTeam("liverpool")
            else
                changeTeam("realmadrid")

        }
        //conectar la lista con el arreglo de datos usuando un adaptador
        //val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,teamNames)
        val adapter = TemasListAdapter(this,R.layout.list_teams,teamNames)
        binding.teamsList.adapter = adapter


        binding.teamsList.setOnItemClickListener { adapterView, view, i, l ->
            println("adapterView: $adapterView \n" +
                    "view: $view \n" +
                    "position: $i \n"+
                    "id: $l"
            )
            changeTeam(teamNames[i].lowercase())
        }
    }

    fun changeTeam(teamName:String){
        //Toast.makeText(this,"You choose ${teamName.capitalize()}",Toast.LENGTH_SHORT).show()
        val id = resources.getIdentifier(teamName,"drawable",packageName)
        binding.imgTeam.setImageResource(id)

    }
}