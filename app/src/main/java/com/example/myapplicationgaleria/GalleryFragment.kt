package com.example.myapplicationgaleria

import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class GalleryFragment : Fragment() {

    private lateinit var rootView: View

    private val lugaresImages = mutableListOf(
        TarjetaLugar(R.drawable.image1, "Card1"),
        TarjetaLugar(R.drawable.image2, "Card2"),
        TarjetaLugar(R.drawable.image3, "Card3"),
        TarjetaLugar(R.drawable.image4, "Card4"),
        TarjetaLugar(R.drawable.image5, "Card5"),
        TarjetaLugar(R.drawable.image6, "Card6"),
        TarjetaLugar(R.drawable.image7, "Card7"),
        TarjetaLugar(R.drawable.image8, "Card8"),
        TarjetaLugar(R.drawable.image9, "Card9")
    )

    private lateinit var adapter: TarjetaLugarAdapter
    private var actionMode: ActionMode? = null

    // Configuración del menú contextual ActionMode
    private var modeCallBack: ActionMode.Callback = object : ActionMode.Callback {
        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
            when (item?.itemId) {
                R.id.action_editar -> Log.i("GalleryFragment", "Editar")
                R.id.action_eliminar -> Log.i("GalleryFragment", "Eliminar")
                R.id.action_compartir -> Log.i("GalleryFragment", "Compartir")
                else -> return false
            }
            mode?.finish()
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean = false

        override fun onDestroyActionMode(mode: ActionMode?) {
            (activity as MainActivity).showToolbar()
            actionMode = null
        }
        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            mode.title = "Opciones"
            mode.menuInflater.inflate(R.menu.menu_context, menu)
            (activity as MainActivity).hideToolbar()
            return true
        }
    }



    private fun initRecyclerView() {
        val recyclerView = rootView.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        adapter = TarjetaLugarAdapter(lugaresImages)
        recyclerView.adapter = adapter

        adapter.onLongClick = { view ->
            view.startActionMode(modeCallBack)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_gallery, container, false)
        initRecyclerView()
        return rootView
    }
}