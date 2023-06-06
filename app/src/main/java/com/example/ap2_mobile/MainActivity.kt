package com.example.ap2_mobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<View>(R.id.start_button)
        startButton.setOnClickListener {
            val intent = Intent(this@MainActivity, RestauranteNomeActivity::class.java)
            startActivity(intent)
        }
    }
}

