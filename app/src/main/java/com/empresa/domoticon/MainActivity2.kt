package com.empresa.domoticon

import android.os.Bundle
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
                encenderBombillas2(numBombillas, binding)
            }

            3 -> { // Si selecciono 3 bombillas, lo redirige al layout activity_3
                val binding = Activity3Binding.inflate(layoutInflater)
                setContentView(binding.root)
                encenderBombillas3(numBombillas, binding)
            }

        }
    }

    fun encenderBombillas2(numBombillas: Int, binding: ActivityMain2Binding) {
        val bombillas = arrayOf(binding.img1, binding.img2,)
        val botones = arrayOf(binding.btn1, binding.btn2)
        val checkboxes = arrayOf(binding.checkbox1, binding.checkbox2)

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

        binding.btnReset.setOnClickListener {
            checkboxes.forEachIndexed { i, checkBox ->
                if (checkBox.isChecked) {
                    botones[i].text = "OFF"
                    bombillas[i].setImageResource(R.drawable.bulb_off)
                }
            }
        }
    }

    fun encenderBombillas3(numBombillas: Int, binding: Activity3Binding) {
        val bombillas = arrayOf(binding.img1, binding.img2, binding.img3)
        val botones = arrayOf(binding.btn1, binding.btn2, binding.btn3)
        val checkboxes = arrayOf(binding.checkbox1, binding.checkbox2, binding.checkbox3)

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

        binding.btnReset.setOnClickListener {
            checkboxes.forEachIndexed { i, checkBox ->
                if (checkBox.isChecked) {
                    botones[i].text = "OFF"
                    bombillas[i].setImageResource(R.drawable.bulb_off)
                }
            }
        }

    }

}