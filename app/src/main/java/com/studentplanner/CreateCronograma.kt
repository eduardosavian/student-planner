package com.studentplanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CreateCronograma : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_cronograma)

        val cancelarButton = findViewById<Button>(R.id.btCancelar)
        val terminarButton = findViewById<Button>(R.id.btTerminar)

        cancelarButton.setOnClickListener {
            val intent = Intent(this, Cronogramas::class.java)

            startActivityForResult(intent, 1)
        }

        terminarButton.setOnClickListener {
            val intent = Intent(this, Cronogramas::class.java)

            startActivityForResult(intent, 1)
        }
    }
}