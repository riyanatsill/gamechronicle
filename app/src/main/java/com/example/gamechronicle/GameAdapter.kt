package com.example.gamechronicle

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GameAdapter(private val gamelist: ArrayList<Games>, private val context: Context) : RecyclerView.Adapter<GameAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, overview, foto) = gamelist[position]
        holder.imgFoto.setImageResource(foto)
        holder.titleTV.text = title
        holder.overviewTV.text = overview

        holder.itemView.setOnClickListener {
            val move = Intent(context, DetailsActivity::class.java)
            move.putExtra("game", gamelist[position])
            context.startActivity(move)
        }
    }

    override fun getItemCount(): Int = gamelist.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgFoto: ImageView = itemView.findViewById(R.id.recImage)
        val titleTV: TextView = itemView.findViewById(R.id.recTitle)
        val overviewTV: TextView = itemView.findViewById(R.id.recOverview)
    }
}
