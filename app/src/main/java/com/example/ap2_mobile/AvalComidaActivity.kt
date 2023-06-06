package com.example.ap2_mobile


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity

class AvalComidaActivity : AppCompatActivity() {

    private lateinit var comidaRatingBar: RatingBar
    private lateinit var restauranteNome: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avaliacao_comida)

        restauranteNome = intent.getStringExtra("restauranteNome") ?:""

        comidaRatingBar = findViewById(R.id.comida_rating_bar)

        val nextButton = findViewById<View>(R.id.next_button)
        nextButton.setOnClickListener {
            val comidaRating = comidaRatingBar.rating
            moveToNextActivity(comidaRating)
        }
    }

    private fun moveToNextActivity(comidaRating: Float) {
        val intent = Intent(this, AvalServicoActivity::class.java)
        intent.putExtra("restauranteNome", restauranteNome)
        intent.putExtra("comidaRating", comidaRating)
        startActivity(intent)
    }
}
