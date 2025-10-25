package com.empresa.domoticon

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
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
                val btnRenew = binding.btnRenew
                val block = binding.switch1

                logicaBotones(bombillas, botones, checkboxes, btnRenew, block)
                intercambio(bombillas, botones, checkboxes, btnRenew, block)
            }

            3 -> { // Si selecciono 3 bombillas, lo redirige al layout activity_3
                val binding = Activity3Binding.inflate(layoutInflater)
                setContentView(binding.root)

                val bombillas = arrayOf(binding.img1, binding.img2, binding.img3)
                val botones = arrayOf(binding.btn1, binding.btn2, binding.btn3)
                val checkboxes = arrayOf(binding.checkbox1, binding.checkbox2, binding.checkbox3)
                val btnRenew = binding.btnRenew
                val block = binding.switch1

                logicaBotones(bombillas, botones, checkboxes, btnRenew, block)
                intercambio(bombillas, botones, checkboxes, btnRenew, block)
            }
        }
    }

    private fun logicaBotones(bombillas: Array<ImageView>, botones: Array<Button>, checkboxes: Array<CheckBox>, btnReset: ImageButton, block: SwitchCompat) {
        botones.forEachIndexed { i, boton ->
            boton.setOnClickListener {
                if (!block.isChecked) { // solo funciona si el switch está apagado
                    if (boton.text == "OFF") {
                        boton.text = "ON"
                        bombillas[i].setImageResource(R.drawable.bulb_on)
                    } else {
                        boton.text = "OFF"
                        bombillas[i].setImageResource(R.drawable.bulb_off)
                    }
                }
            }
        }

        btnReset.setOnClickListener {
            if (!block.isChecked) { // solo funciona si el switch está apagado
                checkboxes.forEachIndexed { i, checkBox ->
                    if (checkBox.isChecked) {
                        botones[i].text = "OFF"
                        bombillas[i].setImageResource(R.drawable.bulb_off)
                    }
                }
            }
        }
    }


    private fun intercambio(bombillas: Array<ImageView>, botones: Array<Button>, checkboxes: Array<CheckBox>, btnRenew: ImageButton, block: SwitchCompat){
        btnRenew.setOnClickListener {
            if (!block.isChecked) { // solo funciona si el switch está apagado
                var c = 0
                checkboxes.forEach { checkbox ->
                    if (checkbox.isChecked) c++
                }

                if (c == 2) {
                    var boton: Button? = null
                    var boton2: Button? = null
                    var indice = 0
                    for (i in 0 until checkboxes.size) {
                        val checkbox = checkboxes[i]

                        if (checkbox.isChecked && boton == null) {
                            boton = botones[i]
                            indice = i
                            continue
                        }

                        if (checkbox.isChecked && boton != null) {
                            boton2 = botones[i]

                            val aux = boton.text
                            botones[indice].text = boton2.text
                            botones[i].text = aux

                            break
                        }
                    }
                } else if (c == 3) {
                    val btn1 = botones[0]
                    val btn2 = botones[1]
                    val btn3 = botones[2]

                    val aux = btn1.text
                    btn1.text = btn3.text
                    btn3.text = btn2.text
                    btn2.text = aux

                    println("Boton 1: " + btn1.text)
                    println("Boton 2: " + btn2.text)
                    println("Boton 3: " + btn3.text)
                }

                actualizarImagenes(bombillas, botones)
            }
        }
    }

    private fun actualizarImagenes(bombillas: Array<ImageView>, botones: Array<Button>) {
        botones.forEachIndexed { i, boton ->
            if (boton.text == "OFF") {
                bombillas[i].setImageResource(R.drawable.bulb_off)
            } else {
                bombillas[i].setImageResource(R.drawable.bulb_on)
            }
        }
    }
}