package com.example.proyecto2trimestre

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto2trimestre.databinding.LoginActivityBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding:LoginActivityBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE)

        if (sharedPreferences.contains("username") && sharedPreferences.contains("password")) {
            val username = sharedPreferences.getString("username", "")
            val password = sharedPreferences.getString("password", "")
            if (username != null && password != null && username.isNotEmpty() && password.isNotEmpty()) {
                login(username, password)
            }
        }

        binding.btLogin.setOnClickListener {
            val username = binding.etUser.text.toString()
            val password = binding.etPassword.text.toString()
            if (login(username, password)) {
                datosUsuario(username, password)
                startActivity(MainActivity::class.java, username)
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }


        binding.tvOlvidada.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            val view = layoutInflater.inflate(R.layout.recuperar_contrasena, null)

            builder.setView(view)

            val dialog = builder.create()
            dialog.show()

            val correo = view.findViewById<EditText>(R.id.etRemail)
            val enviar = view.findViewById<Button>(R.id.btRenviar)
            enviar.setOnClickListener {
                if (!formatoCorreo(correo.text.toString())){
                    Toast.makeText(this, "Correo no válido", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Te hemos enviado un correo con las indicaciones que debes seguir", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }
        }
        binding.tvAyuda.setOnClickListener {
            val phoneNumber = "648867950"
            val formattedPhoneNumber = "+34 $phoneNumber"

            val dialIntent = Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$formattedPhoneNumber"))
            startActivity(dialIntent)
        }
    }
        private fun formatoCorreo(email: String): Boolean {
            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
            return email.matches(emailPattern.toRegex())
        }
    private fun login(username: String, password: String): Boolean {
        val invitado = "Invitado"
        val usuario = "Usuario"
        val admin = "Admin"
        val passInvitado = "nba123"
        val passUsuario = "nba456"
        val passAdmin = "nba789"

        return when {
            (username == invitado && password == passInvitado) ||
                    (username == usuario && password == passUsuario) ||
                    (username == admin && password == passAdmin) -> true
            else -> false
        }
    }

    private fun datosUsuario(username: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putString("username", username)
        editor.putString("password", password)
        editor.apply()
    }

    private fun startActivity(activityClass: Class<*>, username: String) {
        val intent = Intent(this, activityClass).apply {
            putExtra("username", username)
        }
        startActivity(intent)
        finish()
    }


    }




