package com.empresa.domoticon

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.empresa.domoticon.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val numBombillas = intent.getIntExtra("bombillas", 0)

        when (numBombillas) {
            2 -> { // Si selecciono 2 bombillas, lo redirige al layout activity_main_2
                val binding = com.empresa.domoticon.databinding.ActivityMain2Binding.inflate(layoutInflater)
                setContentView(binding.root)
            }

            3 -> { // Si selecciono 3 bombillas, lo redirige al layout activity_3
                val binding = com.empresa.domoticon.databinding.Activity3Binding.inflate(layoutInflater)
                setContentView(binding.root)
            }

        }
    }
}