package com.empresa.domoticon

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.empresa.domoticon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, MainActivity2::class.java)

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p: AdapterView<*>, v: View?, pos: Int, id: Long) {
                when (pos) {
                    1 -> { // Si selecciona el segundo elemento
                        intent.putExtra("bombillas", 2)
                        startActivity(intent)
                    }

                    2 -> { // Si selecciona el tercer elemento
                        intent.putExtra("bombillas", 3)
                        startActivity(intent)
                    }
                }
            }

            // Este método se llama si no se selecciona nada en el Spinner, pero no lo usé
            override fun onNothingSelected(p: AdapterView<*>) {}
        }
    }
}