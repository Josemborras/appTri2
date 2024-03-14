package com.example.proyecto2trimestre

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        binding.btLogout.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmar logout")
            builder.setMessage("¿Estás seguro de que deseas cerrar sesión?")
            builder.setPositiveButton("Aceptar") { _: DialogInterface, _: Int ->
                // Aquí redirige al usuario a la pantalla de login
                // por ejemplo:
                // startActivity(Intent(this, LoginActivity::class.java))
            }
            builder.setNegativeButton("Cancelar") { dialog: DialogInterface, _: Int ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }

    }
    override fun onSupportNavigateUp() = navController.navigateUp(appBarConfiguration)


}
