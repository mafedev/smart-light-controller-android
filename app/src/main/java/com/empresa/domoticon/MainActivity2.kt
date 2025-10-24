package com.empresa.domoticon

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.empresa.domoticon.databinding.Activity3Binding
import com.empresa.domoticon.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val numBombillas = intent.getIntExtra("bombillas", 0)

        when (numBombillas) {
            2 -> { // Si selecciono 2 bombillas, lo redirige al layout activity_main_2
                val binding = ActivityMain2Binding.inflate(layoutInflater)
                setContentView(binding.root)

                val bombillas = arrayOf(binding.img1, binding.img2,)
                val botones = arrayOf(binding.btn1, binding.btn2)
                val checkboxes = arrayOf(binding.checkbox1, binding.checkbox2)
                val btnReset = binding.btnReset

                logicaBotones(bombillas, botones, checkboxes, btnReset)
            }

            3 -> { // Si selecciono 3 bombillas, lo redirige al layout activity_3
                val binding = Activity3Binding.inflate(layoutInflater)
                setContentView(binding.root)

                val bombillas = arrayOf(binding.img1, binding.img2, binding.img3)
                val botones = arrayOf(binding.btn1, binding.btn2, binding.btn3)
                val checkboxes = arrayOf(binding.checkbox1, binding.checkbox2, binding.checkbox3)
                val btnReset = binding.btnReset

                logicaBotones(bombillas, botones, checkboxes, btnReset)
            }
        }
    }

    private fun logicaBotones(bombillas: Array<ImageView>, botones: Array<Button>, checkboxes: Array<CheckBox>, btnReset: Button) {
        botones.forEachIndexed { i, boton ->
            boton.setOnClickListener {
                if (boton.text == "OFF") {
                    boton.text = "ON"
                    bombillas[i].setImageResource(R.drawable.bulb_on)
                } else {
                    boton.text = "OFF"
                    bombillas[i].setImageResource(R.drawable.bulb_off)
                }
            }
        }

        btnReset.setOnClickListener {
            checkboxes.forEachIndexed { i, checkBox ->
                if (checkBox.isChecked) {
                    botones[i].text = "OFF"
                    bombillas[i].setImageResource(R.drawable.bulb_off)
                }
            }
        }
    }
}