package com.empresa.domoticon

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import com.empresa.domoticon.databinding.Activity3Binding
import com.empresa.domoticon.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    // nuevas propiedades para poder guardar/restaurar estado
    private lateinit var bombillasViews: Array<ImageView>
    private lateinit var botonesViews: Array<Button>
    private lateinit var checkboxesViews: Array<CheckBox>
    private lateinit var blockView: SwitchCompat
    private var numBombillas = 0

    companion object {
        private const val KEY_BUTTON_TEXTS = "key_button_texts"
        private const val KEY_CHECKBOXES = "key_checkboxes"
        private const val KEY_BLOCK = "key_block"
        private const val KEY_NUM_BOMBILLAS = "key_num_bombillas"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        numBombillas = intent.getIntExtra("bombillas", 0)

        when (numBombillas) {
            2 -> { // Si selecciono 2 bombillas, lo redirige al layout activity_main_2
                val binding = ActivityMain2Binding.inflate(layoutInflater)
                setContentView(binding.root)

                // asigno a las propiedades para poder guardarlas después
                bombillasViews = arrayOf(binding.img1, binding.img2)
                botonesViews = arrayOf(binding.btn1, binding.btn2)
                checkboxesViews = arrayOf(binding.checkbox1, binding.checkbox2)
                val btnRenew = binding.btnRenew
                blockView = binding.switch1

                // restaura si venía savedInstanceState
                if (savedInstanceState != null && savedInstanceState.getInt(KEY_NUM_BOMBILLAS, numBombillas) == numBombillas) {
                    val textos = savedInstanceState.getStringArray(KEY_BUTTON_TEXTS)
                    val checks = savedInstanceState.getBooleanArray(KEY_CHECKBOXES)
                    val bloqueado = savedInstanceState.getBoolean(KEY_BLOCK, false)

                    if (textos != null && textos.size == botonesViews.size) {
                        for (i in botonesViews.indices) botonesViews[i].text = textos[i]
                    }
                    if (checks != null && checks.size == checkboxesViews.size) {
                        for (i in checkboxesViews.indices) checkboxesViews[i].isChecked = checks[i]
                    }
                    blockView.isChecked = bloqueado

                    actualizarImagenes(bombillasViews, botonesViews)
                }

                logicaBotones(bombillasViews, botonesViews, checkboxesViews, btnRenew, blockView)
            }

            3 -> { // Si selecciono 3 bombillas, lo redirige al layout activity_3
                val binding = Activity3Binding.inflate(layoutInflater)
                setContentView(binding.root)

                bombillasViews = arrayOf(binding.img1, binding.img2, binding.img3)
                botonesViews = arrayOf(binding.btn1, binding.btn2, binding.btn3)
                checkboxesViews = arrayOf(binding.checkbox1, binding.checkbox2, binding.checkbox3)
                val btnRenew = binding.btnRenew
                blockView = binding.switch1

                if (savedInstanceState != null && savedInstanceState.getInt(KEY_NUM_BOMBILLAS, numBombillas) == numBombillas) {
                    val textos = savedInstanceState.getStringArray(KEY_BUTTON_TEXTS)
                    val checks = savedInstanceState.getBooleanArray(KEY_CHECKBOXES)
                    val bloqueado = savedInstanceState.getBoolean(KEY_BLOCK, false)

                    if (textos != null && textos.size == botonesViews.size) {
                        for (i in botonesViews.indices) botonesViews[i].text = textos[i]
                    }
                    if (checks != null && checks.size == checkboxesViews.size) {
                        for (i in checkboxesViews.indices) checkboxesViews[i].isChecked = checks[i]
                    }
                    blockView.isChecked = bloqueado

                    actualizarImagenes(bombillasViews, botonesViews)
                }

                logicaBotones(bombillasViews, botonesViews, checkboxesViews, btnRenew, blockView)
            }
        }
    }

    private fun logicaBotones(bombillas: Array<ImageView>, botones: Array<Button>, checkboxes: Array<CheckBox>, btnRenew: ImageButton, block: SwitchCompat) {

        // Lógica botones apagar/encender
        botones.forEach { boton ->
            boton.setOnClickListener {
                if (!block.isChecked) { // Si el switch para bloquear no está activado, ejecuta la lógica
                    // Cambia el texto de los botones
                    if (boton.text == "OFF") { // Si está apagado, pasa a encendido
                        boton.text = "ON"
                    } else {
                        boton.text = "OFF"
                    }
                    actualizarImagenes(bombillas, botones) // y luego actualiza las imágenes
                }
            }
        }

        // Botón para intercambiar el estado de las bombillas
        btnRenew.setOnClickListener {
            if (!block.isChecked) { // Si el switch no está activado
                // contador, cuenta cuántas checkboxes están seleccionadas
                var c = 0

                // Hace un bucle, si está seleccionada, aumenta el contador
                checkboxes.forEach { checkbox ->
                    if (checkbox.isChecked) c++
                }

                if (c == 2) { // Si hay dos seleccionadas (aunque sea en el layout con 3 bombillas)
                    // se crean dos variables para los botones de las bombillas seleccionadas
                    var boton1: Button? = null
                    val boton2: Button?
                    var indice = 0 // Guarda el índice del primer botón

                    // itera los arrays para obtener los botones seleccionados y hacer el intercambio
                    for (i in 0 until checkboxes.size) {
                        val checkbox = checkboxes[i] // Toma el checkbox en esa posición

                        // Si está seleccionado y boton1 todavía no tiene valor, lo guarda como el primero
                        if (checkbox.isChecked && boton1 == null) {
                            boton1 = botones[i] // lo guarda
                            indice = i // guarda el índice
                            continue // vuelve al inicio del bucle
                        }

                        // Si está seleccionado y ya hay un botón guardado en boton1
                        if (checkbox.isChecked && boton1 != null) {
                            boton2 = botones[i] // lo guarda en el boton2

                            // Hace el intercambio de los textos
                            val aux = boton1.text
                            botones[indice].text = boton2.text
                            botones[i].text = aux
                            break // Termina el bucle
                        }
                    }
                } else if (c == 3) { // Si se seleccionaron 3 bombillas
                    // Obtiene el valor de los tres botones
                    val btn1 = botones[0]
                    val btn2 = botones[1]
                    val btn3 = botones[2]

                    // Hace el intercambio: 1->3, 2->1, 3->2
                    val aux = btn1.text
                    btn1.text = btn3.text
                    btn3.text = btn2.text
                    btn2.text = aux
                }
                actualizarImagenes(bombillas, botones) // Luego de hacer el cambio del texto, se actualizan las imágenes
            }
        }
    }

    // Actualiza las imágenes de las bombillas
    private fun actualizarImagenes(bombillas: Array<ImageView>, botones: Array<Button>) { // Recibe las bombillas y los botones
        // Itera los botones y, según el texto, muestra la imagen correspondiente
        botones.forEachIndexed { i, boton ->
            if (boton.text == "OFF") {
                bombillas[i].setImageResource(R.drawable.bulb_off)
            } else {
                bombillas[i].setImageResource(R.drawable.bulb_on)
            }
        }
    }

    // se uarda el estado antes de destruir la actividad
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(KEY_NUM_BOMBILLAS, numBombillas)

        if (::botonesViews.isInitialized) {
            val textos = botonesViews.map { it.text.toString() }.toTypedArray()
            outState.putStringArray(KEY_BUTTON_TEXTS, textos)
        }
        if (::checkboxesViews.isInitialized) {
            val checks = BooleanArray(checkboxesViews.size) { i -> checkboxesViews[i].isChecked }
            outState.putBooleanArray(KEY_CHECKBOXES, checks)
        }
        if (::blockView.isInitialized) {
            outState.putBoolean(KEY_BLOCK, blockView.isChecked)
        }
    }
}