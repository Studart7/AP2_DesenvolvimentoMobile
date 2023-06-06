package com.example.ap2_mobile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {

    private lateinit var resultadoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        resultadoTextView = findViewById(R.id.resultado_text_view)

        val restauranteNome = intent.getStringExtra("restauranteNome") ?: ""
        val comidaRating = intent.getFloatExtra("comidaRating", 0.0f)
        val servicoRating = intent.getFloatExtra("servicoRating", 0.0f)

        val resultado = calculateResult(comidaRating, servicoRating)

        resultadoTextView.text = "Restaurante: $restauranteNome\n\n" +
                "Avaliação da comida: $comidaRating estrelas\n" +
                "Avaliação do serviço: $servicoRating estrelas\n\n" +
                "Resultado: $resultado"

        val btMail = findViewById<Button>(R.id.btMail)
        btMail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("danielstudart45@gmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Review do Restaurante")
            intent.putExtra(Intent.EXTRA_TEXT, "Queria contar mais sobre minha experiencia: ")
            startActivity(intent)
        }
    }

    private fun calculateResult(comidaRating: Float, servicoRating: Float): String {
        // Lógica para calcular o resultado com base nas avaliações da comida e do serviço
        // Substitua esta lógica com a sua própria implementação
        val resultado = (comidaRating + servicoRating)/2
        if (resultado >= 4.5){
            return "Excelente"
        }
        else if (resultado >= 3.5 && resultado < 4.5){
            return "Ótimo"
        }
        else if (resultado >= 2.8 && resultado < 3.5){
            return "Ok"
        }
        else{
            return "Ruim"
        }

    }
}
