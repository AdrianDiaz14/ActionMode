package com.example.myapplicationgaleria

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        //La NavigationUI usa un objeto AppBarConfiguration para administrar el comportamiento del botón Navigation en la esquina superior izquierda de la ToolBar.
        // Definimos varios destinos de nivel superior, ya que no guardan relación entre ellos.
        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)

        //El controlador de navegación posiciona el botón de navegación sobre la ToolBar y le da funcionalidad.
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }


    // Método para ocultar la Toolbar
    fun hideToolbar() {
        supportActionBar?.hide()
    }

    // Método para mostrar la Toolbar
    fun showToolbar() {
        supportActionBar?.show()
    }

    //Método para desplegar el navegador lateral deslizante al hacer click sobre el panel lateral o botón de navegación de la ToolBar
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}