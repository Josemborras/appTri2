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
        galeria.add(R.drawable._6ers_bucks)
        galeria.add(R.drawable.clippers_bulls)
        galeria.add(R.drawable.dallas_thunder)
        galeria.add(R.drawable.newyork_portland)
        galeria.add(R.drawable.phoenix_boston)
        galeria.add(R.drawable.atlanta_jazz)
        galeria.add(R.drawable.nets_pacers)
        galeria.add(R.drawable.nuggets_spurs)
        galeria.add(R.drawable.warriors_lakers)




        val adapter = PartidosAdapter(galeria)
        binding.viewPager2.adapter = adapter

        val adapterDeslizante = DeslizanteAdapter(galeria)

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewPartidos.layoutManager = layoutManager
        binding.recyclerViewPartidos.adapter = adapterDeslizante

        adapterDeslizante.setOnImageClickListener { position ->
            binding.viewPager2.setCurrentItem(position, true)
        }

    }
}