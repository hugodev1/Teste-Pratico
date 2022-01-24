package com.hugo.testesoma

// convenção do view binding do android
import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.hugo.testesoma.databinding.ActivityShowBinding


class ShowActivity : AppCompatActivity() {

    // convenção do view binding do android
    private lateinit var binding: ActivityShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // convenção do view binding do android
        binding = ActivityShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // com binding
        val resultOfSum = intent.extras?.getInt("sum")
//        val novoInt = intent.extras?.getInt("novo_inteiro")
//        val meuNome = intent.extras?.getString("nome")
//        binding.resultOfSum.text = resultOfSum.toString()


        binding.viewCanvas.resultOfSum = resultOfSum ?: 0
    }

}