package com.example.proyecto2trimestre

import android.icu.text.Transliterator.Position
import android.os.Build
import com.example.proyecto2trimestre.adaptadores.RosterAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto2trimestre.adaptadores.EquiposAdapter
import com.example.proyecto2trimestre.adaptadores.bostonR
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

        equipo?.let {
            binding.tvCampeonatos.text = it.titulos.toString()
            binding.ivLogo.setImageResource(it.logo)
        }


    }

}