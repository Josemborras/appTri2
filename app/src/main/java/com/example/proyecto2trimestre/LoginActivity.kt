package com.example.proyecto2trimestre

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto2trimestre.databinding.LoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val invitado = "invitado"
        val usuario = "usuario"
        val admin = "admin"
        val passInvitado = "nba123"
        val passUsuario = "nba456"
        val passAdmin = "nba789"


        binding.btLogin.setOnClickListener {
            if (binding.etUser.text.toString() == invitado && binding.etPassword.text.toString() == passInvitado) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else if (binding.etUser.text.toString() == usuario && binding.etPassword.text.toString() == passUsuario) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else if (binding.etUser.text.toString() == admin && binding.etPassword.text.toString() == passAdmin) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else if (binding.etUser.text.toString() == invitado && binding.etPassword.text.toString() != passInvitado) {
                binding.etPassword.error = "Contraseña incorrecta"
            } else if (binding.etUser.text.toString() == usuario && binding.etPassword.text.toString() != passInvitado) {
                binding.etPassword.error = "Contraseña incorrecta"
            } else if (binding.etUser.text.toString() == admin && binding.etPassword.text.toString() != passInvitado) {
                binding.etPassword.error = "Contraseña incorrecta"
            } else {
                binding.etUser.error = "Datos incorrectos"
                binding.etPassword.error = "Datos incorrectos"
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
    fun formatoCorreo(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }


    }



