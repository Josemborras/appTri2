package com.example.proyecto2trimestre

import android.graphics.Color
import android.os.Build
import com.example.proyecto2trimestre.adaptadores.RosterAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto2trimestre.dataClass.FranNBA
import com.example.proyecto2trimestre.databinding.FragmentRosterBinding


class RosterFragment : Fragment() {
    private lateinit var binding: FragmentRosterBinding
    private lateinit var rosterAdapter: Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRosterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(requireContext())

        val equipo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable(
                "equipo", FranNBA::class.java
            )
        } else {
            arguments?.getParcelable<FranNBA>("equipo")
        }

        val adaptador = equipo?.roster?.let { RosterAdapter(it) }
        binding.recyclerView2.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView2.adapter = adaptador

        val nombreEquipo = equipo?.nombre + " " + equipo?.nick



        (requireActivity() as AppCompatActivity).supportActionBar?.title = nombreEquipo

        equipo?.let {
            binding.tvCampeonatos.text = it.titulos.toString()
            binding.ivLogo.setImageResource(it.logo)
            val colorInt = Color.parseColor(it.color)
            binding.colorBackground.setBackgroundColor(colorInt)
            when (it.nombre) {
                "Dallas", "Atlanta", "Denver", "Charlotte", "Brooklyn", "Boston", "Houston", "LA", "Chicago", "Los Angeles","Minnesota", "New Orleans", "Miami", "Oklahoma","Milwaukee", "Phoenix", "New York","Orlando","Sacramento","Philadelphia","Utah"    -> {
                    binding.tvCampeonatos.setTextColor(Color.WHITE)
                    binding.tvTitulos.setTextColor(Color.WHITE)
                }
                // Agrega más casos según sea necesario
                else -> {
                    // Color por defecto o cualquier otro color deseado
                    binding.tvCampeonatos.setTextColor(Color.BLACK)
                    binding.tvTitulos.setTextColor(Color.BLACK)
                }
            }
        }

    }

}