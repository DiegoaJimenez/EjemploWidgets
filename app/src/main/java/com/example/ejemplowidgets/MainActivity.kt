package com.example.ejemplowidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejemplowidgets.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
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
    }

    fun changeTeam(teamName:String){
        //Toast.makeText(this,"You choose ${teamName.capitalize()}",Toast.LENGTH_SHORT).show()
        val id = resources.getIdentifier(teamName,"drawable",packageName)
        binding.imgTeam.setImageResource(id)

    }
}