package com.example.ejemplowidgets

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.ejemplowidgets.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var adapter:TemasListAdapter
    val teamNames = arrayListOf(
        TeamInfo("Liverpool",R.drawable.liverpool,"United Kingdom","1892","https://www.liverpoolfc.com","geo:53.4308294,-2.9634049z=17"),
        TeamInfo("Real Madrid",R.drawable.realmadrid,"Spain","1910","https://www.realmadrid.com/en","geo:21.0851735,-60.5453569z=4")
        )




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println(intent)
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
        adapter = TemasListAdapter(this,R.layout.list_teams,teamNames)
        binding.teamsList.adapter = adapter


        binding.teamsList.setOnItemClickListener { adapterView, view, i, l ->
            println("adapterView: $adapterView \n" +
                    "view: $view \n" +
                    "position: $i \n"+
                    "id: $l"
            )
            //changeTeam(teamNames[i].lowercase())
            openTeamInfoActivity(teamNames[i])
        }
    }

    fun changeTeam(teamName:String){
        //Toast.makeText(this,"You choose ${teamName.capitalize()}",Toast.LENGTH_SHORT).show()
        val id = resources.getIdentifier(teamName,"drawable",packageName)
        binding.imgTeam.setImageResource(id)
        teamNames.add(TeamInfo("Millonarios",0,"Colombia","1946","http://google.com","ere"))
        adapter.notifyDataSetChanged()
    }

    fun openTeamInfoActivity(team: TeamInfo){
        val teamInfoIntent = Intent(this,InfoTeamActivity::class.java)
        teamInfoIntent.putExtra("TEAM_DATA",team)
        startActivity(teamInfoIntent)

    }
}