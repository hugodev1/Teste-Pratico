package com.hugo.testesoma

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hugo.testesoma.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var resultOfSum: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Example of a call to a native method
        //binding.sampleText.text = stringFromJNI()
        //binding.sampleText.text = somaFromJNI(1, 5).toString()

        binding.buttonSum.setOnClickListener {
            /*
            resultOfSum = somaFromJNI(
                binding.numA.text.toString().toInt(),
                binding.numB.text.toString().toInt()
            )
            */

            resultOfSum = Calculadora.soma(
                binding.numA.text.toString().toInt(),
            )

            binding.sampleText.text = "Resultado: " + resultOfSum
        }

        binding.buttonSend.setOnClickListener {
            val intent = Intent(this, ShowActivity::class.java)

            val bundle = Bundle()
            bundle.putInt("sum", resultOfSum)
            bundle.putInt("novo_inteiro", 123)
            bundle.putString("nome", "Hugo")

            intent.putExtras(bundle)

            startActivity(intent)
        }
    }

    /**
     * A native method that is implemented by the 'testesoma' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    external fun somaFromJNI(a: Int, b: Int): Int

    companion object {
        // Used to load the 'testesoma' library on application startup.
        init {
            System.loadLibrary("testesoma")
        }
    }
}