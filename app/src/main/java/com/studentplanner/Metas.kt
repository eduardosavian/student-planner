package com.studentplanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Meta(val horas: String, val descricao: String) {}

class ItemMeta(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val nome: TextView
    val pais: TextView

    init {
        nome = itemView.findViewById<TextView>(R.id.status)
        pais = itemView.findViewById<TextView>(R.id.countryView)
    }
}

class MeuAdaptadorMeta(val dados: List<Meta>) : RecyclerView.Adapter<ItemMeta>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemMeta {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_meta, parent, false)

        return ItemMeta(view)
    }

    override fun getItemCount(): Int {
        return dados.size
    }

    override fun onBindViewHolder(holder: ItemMeta, position: Int) {
        holder.nome.text = dados[position].horas
        holder.pais.text = dados[position].descricao
    }
}

class Metas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metas)

        val voltaButton = findViewById<Button>(R.id.btVolta)

        voltaButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("param", "Ola mundo")

            startActivityForResult(intent, 1)
        }

        val metas = listOf(
            Meta("✓", "Estudar Geografia"),
            Meta("✓", "Estudar Física"),
            Meta("✓", "Estudar Química"),
            Meta("x", "Estudar Alemão"),
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adaptador = MeuAdaptadorMeta(metas)

        recyclerView.adapter = adaptador
        recyclerView.layoutManager = LinearLayoutManager(this)
    }


}