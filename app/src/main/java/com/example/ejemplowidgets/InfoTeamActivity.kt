package com.example.ejemplowidgets

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.ejemplowidgets.databinding.ActivityInfoTeamBinding

class InfoTeamActivity : AppCompatActivity() {

    lateinit var binding:ActivityInfoTeamBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val team = intent.getSerializableExtra("TEAM_DATA") as TeamInfo
        binding.teamName2.text = team.name
        binding.teamOrigin.text = "${team.country},${team.founded}"
        binding.teamFlag.setImageResource(team.flag)
        binding.btnWebpage.setOnClickListener { openTeamWebpage(team.webpage) }
        binding.btnMap.setOnClickListener { openTeamMap(team.stadiumLocation) }
        binding.input.text

    }

    fun openTeamWebpage(url:String){
        //buscar en url "geo:53.4308294,-2.9634049,17z"
        val webpage = Uri.parse(url)
        val webIntent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(webIntent)
        }

    fun openTeamMap(url2:String){
        val mapIntent: Intent = Uri.parse(url2).let{
            location -> Intent(Intent.ACTION_VIEW, location)
        }
        startActivity(mapIntent)
    }


    }
