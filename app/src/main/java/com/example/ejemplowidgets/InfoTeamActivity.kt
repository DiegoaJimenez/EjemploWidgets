package com.example.ejemplowidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class InfoTeamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_team)

        val teamName = intent.getStringExtra("TEAM_NAME")
        val textView = findViewById<TextView>(R.id.teamName2)
        textView.text = teamName
    }
}