package com.example.ejemplowidgets

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
    }
}