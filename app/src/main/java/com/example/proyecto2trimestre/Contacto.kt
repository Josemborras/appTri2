package com.example.proyecto2trimestre

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
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

        botonesContacto()
        setupSubmitButton()
    }

    private fun botonesContacto() {
        binding.cvCorreo.setOnClickListener {
            sendEmail("info@escuelaestech.es")
        }

        binding.cvTelefono.setOnClickListener {
            dialPhoneNumber("+34 953636000")
        }

        binding.cvLocalizacion.setOnClickListener {
            openGoogleMapsLocation()
        }

        binding.cvWhatsapp.setOnClickListener {
            openWhatsAppChat("+34 697246008")
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
        val nombre = binding.textInputLayout.editText?.text.toString().trim()
        val correo = binding.textInputLayout2.editText?.text.toString().trim()
        val telefono = binding.textInputLayout3.editText?.text.toString().trim()

        if (nombre.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
            Toast.makeText(requireContext(), "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show()
            return false
        }
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
        val nombre = binding.tNombre.text.toString()
        val correo = binding.tCorreo.text.toString()
        val telefono = binding.tTelefono.text.toString()
        val checkBox = binding.checkBox

        if ((nombre.isNotEmpty() && correo.isNotEmpty() && telefono.isNotEmpty() && checkBox.isChecked) && (formatoEmail(correo))) {

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("destinatario@example.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto del correo")
            intent.putExtra(Intent.EXTRA_TEXT, "Nombre: $nombre\nCorreo electrónico: $correo\nTeléfono: $telefono")

            try {
                startActivity(Intent.createChooser(intent, "Enviar correo"))
            } catch (_: ActivityNotFoundException) {

            }
        } else {
            Toast.makeText(requireContext(), "Debes rellenar todos los campos y marcar el checkbox", Toast.LENGTH_SHORT).show()
        }
    }


    private fun sendEmail(email: String) {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:$email")
        try {
            startActivity(intent)
        } catch (_: ActivityNotFoundException) {

        }
    }

    private fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$phoneNumber")
        try {
            startActivity(intent)
        } catch (_: ActivityNotFoundException) {

        }
    }

    private fun openGoogleMapsLocation() {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("geo:38.0942672,-3.631339?q=Escuela+Estech")
        )
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity")
        startActivity(intent)


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
    private fun formatoEmail(email: String): Boolean {
        val pattern = Regex("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,})+$")
        return pattern.matches(email)
    }


}
