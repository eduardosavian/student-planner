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

data class Estatistica(val horas: String, val descricao: String) {}

class ItemEstatistica(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val nome: TextView
    val pais: TextView

    init {
        nome = itemView.findViewById<TextView>(R.id.status)
        pais = itemView.findViewById<TextView>(R.id.dataCronograma)
    }
}

class MeuAdaptadorEstistica(val dados: List<Estatistica>) : RecyclerView.Adapter<ItemEstatistica>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemEstatistica {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_lista, parent, false)

        return ItemEstatistica(view)
    }

    override fun getItemCount(): Int {
        return dados.size
    }

    override fun onBindViewHolder(holder: ItemEstatistica, position: Int) {
        holder.nome.text = dados[position].horas
        holder.pais.text = dados[position].descricao
    }
}

class Estatisticas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estatisticas)

        val voltaButton = findViewById<Button>(R.id.btVolta)

        voltaButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("param", "Ola mundo")

            startActivityForResult(intent, 1)
        }

        val estatisticas = listOf(
            Estatistica("10", "Horas planejadas"),
            Estatistica("10", "Média de horas"),
            Estatistica("10", "Horas estudadas"),
            Estatistica("12", "Horas faltantes"),
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adaptador = MeuAdaptadorEstistica(estatisticas)

        recyclerView.adapter = adaptador
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}