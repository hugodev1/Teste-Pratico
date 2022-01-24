package com.hugo.testesoma

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // definir o layout em xml
        setContentView(R.layout.activity_resultado)

        // como obter o elemento visual
        val tvResult = findViewById<TextView>(R.id.tvResult)

        if (tvResult != null) {
            tvResult.text = "meu resultado"
        }
    }
}