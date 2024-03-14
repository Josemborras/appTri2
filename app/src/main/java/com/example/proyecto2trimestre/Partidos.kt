package com.example.proyecto2trimestre

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto2trimestre.adaptadores.DeslizanteAdapter
import com.example.proyecto2trimestre.adaptadores.PartidosAdapter
import com.example.proyecto2trimestre.databinding.PartidosFragmentBinding

class Partidos : Fragment() {
    private lateinit var binding: PartidosFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PartidosFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val galeria = ArrayList<Int>()
        galeria.add(R.drawable.anteto)
        galeria.add(R.drawable.durant)
        galeria.add(R.drawable.jimmy_butler)
        galeria.add(R.drawable.jokic)
        galeria.add(R.drawable.tatum)
        galeria.add(R.drawable.partido1)
        galeria.add(R.drawable.partido2)
        galeria.add(R.drawable.partido3)
        galeria.add(R.drawable.partido4)
        galeria.add(R.drawable.partido5)
        galeria.add(R.drawable.partido6)



        val adapter = PartidosAdapter(galeria)
        binding.viewPager2.adapter = adapter

        val adapterDeslizante = DeslizanteAdapter(galeria)

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewPartidos.layoutManager = layoutManager
        binding.recyclerViewPartidos.adapter = adapterDeslizante



    }
}