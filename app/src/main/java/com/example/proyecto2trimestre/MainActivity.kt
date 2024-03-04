package com.example.proyecto2trimestre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.proyecto2trimestre.databinding.DesplegableBinding

class MainActivity : AppCompatActivity() {
    
    private lateinit var navController: NavController
    private lateinit var binding: DesplegableBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DesplegableBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView3) as NavHost
        navController = navHost.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.inicio,
                R.id.partidos,
                R.id.clasificacion,
                R.id.contacto

            ), binding.drawerLayout
        )
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.nvDesplegable.setupWithNavController(navController)
    }
    override fun onSupportNavigateUp() = navController.navigateUp(appBarConfiguration)
}