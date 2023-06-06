package com.example.ap2_mobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AvalServicoActivity : AppCompatActivity() {

    private lateinit var servicoRatingBar: RatingBar
    private lateinit var restauranteNome: String
    private var comidaRating: Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avaliacao_servico)

        restauranteNome = intent.getStringExtra("restauranteNome") ?: ""
        comidaRating = intent.getFloatExtra("comidaRating", 0.0f)

        servicoRatingBar = findViewById(R.id.servico_rating_bar)

        val nextButton = findViewById<View>(R.id.next_button)
        nextButton.setOnClickListener {
            val servicoRating = servicoRatingBar.rating
            moveToResultActivity(servicoRating)
        }
    }

    private fun moveToResultActivity(servicoRating: Float) {
        val intent = Intent(this, ResultadoActivity::class.java)
        intent.putExtra("restauranteNome", restauranteNome)
        intent.putExtra("comidaRating", comidaRating)
        intent.putExtra("servicoRating", servicoRating)
        startActivity(intent)
        finish()
    }
}

