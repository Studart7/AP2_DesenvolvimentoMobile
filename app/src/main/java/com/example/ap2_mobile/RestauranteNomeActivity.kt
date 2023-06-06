package com.example.ap2_mobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RestauranteNomeActivity : AppCompatActivity() {

    private lateinit var restauranteNomeEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante_nome)

        restauranteNomeEditText = findViewById(R.id.restaurante_nome_edit_text)

        val nextButton = findViewById<View>(R.id.next_button)
        nextButton.setOnClickListener {
            val restauranteNome = restauranteNomeEditText.text.toString()
            moveToNextActivity(restauranteNome)
        }
    }

    private fun moveToNextActivity(restauranteNome: String) {
        val intent = Intent(this, AvalComidaActivity::class.java)
        intent.putExtra("restauranteNome", restauranteNome)
        startActivity(intent)
    }
}





