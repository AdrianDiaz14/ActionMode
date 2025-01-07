package com.example.myapplicationgaleria

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TarjetaLugarAdapter(val lugaresImagesList:List<TarjetaLugar>) : RecyclerView.Adapter<LugarViewHolder>() {

    lateinit var onLongClick: (View) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugarViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return LugarViewHolder(layoutInflater.inflate(R.layout.item_lugar, parent, false))
    }

    override fun onBindViewHolder(holder: LugarViewHolder, position: Int) {
        val item = lugaresImagesList[position]
        holder.bind(item)
        holder.itemView.setOnLongClickListener {
            onLongClick(holder.itemView)
            true
        }
    }

    override fun getItemCount(): Int {
        return lugaresImagesList.size
    }
}