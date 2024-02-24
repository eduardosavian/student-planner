package com.studentplanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Cronograma(val data: String = "1", val compromisso: String = "1") {}

class ItemCronograma(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val data: TextView
    val compromisso: TextView

    init {
        data = itemView.findViewById<TextView>(R.id.dataCronograma)
        compromisso = itemView.findViewById<TextView>(R.id.compromissoCronograma)
    }
}

class MeuAdaptadorCronograma(val dados: List<Cronograma>) : RecyclerView.Adapter<ItemCronograma>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCronograma {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_lista_cronograma, parent, false)

        return ItemCronograma(view)
    }

    override fun getItemCount(): Int {
        return dados.size
    }

    override fun onBindViewHolder(holder: ItemCronograma, position: Int) {
        holder.data.text = dados[position].data
        holder.compromisso.text = dados[position].compromisso
    }
}

class Cronogramas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cronograma)

        val voltaButton = findViewById<Button>(R.id.btVolta)
        val criarButton = findViewById<Button>(R.id.btCriarCronograma)

        voltaButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivityForResult(intent, 1)
        }

        criarButton.setOnClickListener{
            val intent = Intent(this, CreateCronograma::class.java)

            startActivityForResult(intent, 1)
        }

        val cronogramas = listOf(
            Cronograma("10/10 13:20-15:50", "Estudar Tudo que eu quiser pra ser alguém"),
            Cronograma("17/10", "Prova de S.O."),
            Cronograma("25/12", "Estudar Redes Caps. 1, 3"),
            Cronograma("30/12", "Estudar Processamento de imagens"),
            Cronograma("31/12", "Estudar Processamento de imagens 2"),
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adaptador = MeuAdaptadorCronograma(cronogramas)

        recyclerView.adapter = adaptador
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}