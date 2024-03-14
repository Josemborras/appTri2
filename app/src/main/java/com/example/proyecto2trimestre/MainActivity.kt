package com.example.proyecto2trimestre

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.proyecto2trimestre.databinding.DesplegableMenuBinding

class MainActivity : AppCompatActivity() {
    
    private lateinit var navController: NavController
    private lateinit var binding: DesplegableMenuBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DesplegableMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHost = supportFragmentManager.findFragmentById(R.id.fcwDesplegable) as NavHost
        navController = navHost.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.Inicio,
                R.id.Partidos,
                R.id.Equipos,
                R.id.Contacto

            ), binding.drawerLayout
        )
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.nvDesplegable.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            supportActionBar?.title = when (destination.id) {
                R.id.Inicio -> "Inicio"
                R.id.Partidos -> "Partidos"
                R.id.Equipos -> "Equipos"
                R.id.Contacto -> "Contacto"
                else -> title
            }
        }

        val username = intent.getStringExtra("username")

        binding.nvDesplegable.getHeaderView(0).findViewById<TextView>(R.id.tvUser).text = username

    }
    override fun onSupportNavigateUp() = navController.navigateUp(appBarConfiguration)


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.log_out_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.log_out-> {
                val builder = AlertDialog.Builder(this)
            builder.setTitle("Cerrar sesión")
            builder.setMessage("¿Estás seguro de que deseas cerrar sesión?")
            builder.setPositiveButton("Aceptar") { _: DialogInterface, _: Int ->
               startActivity(Intent(this, LoginActivity::class.java))
            }
            builder.setNegativeButton("Cancelar") { dialog: DialogInterface, _: Int ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
