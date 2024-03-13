package com.example.proyecto2trimestre

import android.os.Bundle
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.proyecto2trimestre.databinding.ContactoFragmentBinding

class Contacto : Fragment() {
    private lateinit var binding: ContactoFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ContactoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupContactButtons()
        setupSubmitButton()
    }

    private fun setupContactButtons() {
        // Botones de correo
        binding.cvCorreo.setOnClickListener {
            sendEmail("info@escuelaestech.es")
        }

        // Botón teléfono
        binding.cvTelefono.setOnClickListener {
            dialPhoneNumber("953636000")
        }

        // Botón de ubicación
        binding.cvLocalizacion.setOnClickListener {
            openGoogleMapsLocation()
        }

        // Botón de WhatsApp
        binding.cvWhatsapp.setOnClickListener {
            openWhatsAppChat("697246008")
        }
    }

    private fun setupSubmitButton() {
        val submitButton: Button = binding.button
        val checkBox: CheckBox = binding.checkBox

        submitButton.setOnClickListener {
            if (isFormValid() && checkBox.isChecked) {
                showConfirmationDialog()
            }
        }
    }

    private fun isFormValid(): Boolean {
        // Verificar si los campos están llenos
        val nombre = binding.textInputLayout.editText?.text.toString().trim()
        val correo = binding.textInputLayout2.editText?.text.toString().trim()
        val telefono = binding.textInputLayout3.editText?.text.toString().trim()

        if (nombre.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
            // Mostrar Toast si algún campo está vacío
            Toast.makeText(requireContext(), "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show()
            return false
        }

        // Agrega aquíis la lógica para validar el formato del correo electrónico si lo deseas

        return true
    }


    private fun showConfirmationDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Confirmar Envío")
            .setMessage("¿Estás seguro de enviar el formulario?")
            .setPositiveButton("Sí") { _, _ ->
                sendFormByEmail()
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun sendFormByEmail() {
        // Aquí debes agregar la lógica para enviar el formulario por correo electrónico
    }

    private fun sendEmail(email: String) {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:$email")
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            // Maneja la excepción si no hay ninguna aplicación de correo instalada
        }
    }

    private fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$phoneNumber")
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            // Maneja la excepción si no hay ninguna aplicación de teléfono instalada
        }
    }

    private fun openGoogleMapsLocation() {
        // Dirección que se abrirá en Google Maps
        val address = "C/ San Joaquín, 12, 23700 Linares (Jaén)"

        // Crear un URI con la dirección
        val uri = Uri.parse("geo:0,0?q=$address")

        // Crear un intent con la acción ACTION_VIEW y el URI de la dirección
        val mapIntent = Intent(Intent.ACTION_VIEW, uri)

        // Verificar si la aplicación de Google Maps está instalada
        mapIntent.setPackage("com.google.android.apps.maps")

        // Comprobar si hay una actividad que pueda manejar el intent
        if (mapIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(mapIntent)
        } else {
            // Manejar la situación donde la aplicación de Google Maps no está instalada
            // Puedes mostrar un mensaje de error o abrir la página de Google Maps en un navegador web
        }
    }

    private fun openWhatsAppChat(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            // Maneja la excepción si no hay ninguna aplicación de WhatsApp instalada
        }
    }
    private fun isEmailValid(email: String): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }


}
