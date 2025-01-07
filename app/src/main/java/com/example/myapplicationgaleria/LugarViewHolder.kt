package com.example.myapplicationgaleria

import android.view.ContextMenu
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationgaleria.R

class LugarViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnCreateContextMenuListener {    //Se añade OnCreateContextMenuListerner para controlar el menú flotante

    // Configuración del menú flotante al pulsar prolongadamente sobre un item del RecyclerView
    init {
        itemView.setOnCreateContextMenuListener(this)
    }
    override fun onCreateContextMenu(contextMenu: ContextMenu, view: View, contextMenuInfo: ContextMenu.ContextMenuInfo?) {
        contextMenu.add(0, 0, adapterPosition, "Editar")
        contextMenu.add(0, 1, adapterPosition, "Eliminar")
        contextMenu.add(0, 2, adapterPosition, "Compartir")
    }

    val imagen: ImageView = itemView.findViewById(R.id.imageView)
    val titulo = view.findViewById<TextView>(R.id.imageName)


    fun bind(lugarModel:TarjetaLugar) {
        imagen.setImageResource(lugarModel.imagenLugar)
        titulo.text = lugarModel.nombre

    }
}
