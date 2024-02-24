package com.studentplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cronogramaButton = findViewById<Button>(R.id.btCronograma)
        var estatisticasButton = findViewById<Button>(R.id.btEstatisticas)
        var metasButton = findViewById<Button>(R.id.btMetas)

        cronogramaButton.setOnClickListener {
            val intent = Intent(this, Cronogramas::class.java)

            intent.putExtra("param", "Ola mundo")

            startActivityForResult(intent, 1)
        }

        estatisticasButton.setOnClickListener {
            val intent = Intent(this, Estatisticas::class.java)

            intent.putExtra("param", "Ola mundo")

            startActivityForResult(intent, 1)
        }

        metasButton.setOnClickListener {
            val intent = Intent(this, Metas::class.java)

            intent.putExtra("param", "Ola mundo")

            startActivityForResult(intent, 1)
        }
    }
}