package com.example.proyecto2trimestre

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import com.example.proyecto2trimestre.databinding.InicioActivityBinding
import kotlin.random.Random

class Inicio : Fragment() {

    private lateinit var binding: InicioActivityBinding
    private var contador = 0
    private var premioGanado = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = InicioActivityBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.imageView36.setOnClickListener {
            if (!premioGanado) {
                contador++
                if (contador >= 10) {
                    premiosDialog()
                }
            } else {
                Toast.makeText(requireContext(), "¡No seas avariciosa/o!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun premiosDialog() {
        val premios = arrayOf("Cupón de descuento", "3 Meses League Pass Gratis", "Tarjeta de regalo")
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("¡Has ganado un premio!")
            .setItems(premios) { dialogInterface: DialogInterface, i: Int ->
                codigoPremio(premios[i])
                dialogInterface.dismiss()
            }
        val dialog = builder.create()
        dialog.show()
    }

    private fun codigoPremio(premio: String) {
        val codigo = Random.nextInt(10000, 99999)
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Código de premio")
            .setMessage("¡Felicidades! Has ganado $premio. Tu código es: $codigo")
            .setPositiveButton("Aceptar") { dialogInterface: DialogInterface, _: Int ->
                dialogInterface.dismiss()
                premioGanado = true
            }
        val dialog = builder.create()
        dialog.show()
    }

}