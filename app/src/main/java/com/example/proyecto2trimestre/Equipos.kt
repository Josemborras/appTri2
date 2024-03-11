package com.example.proyecto2trimestre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto2trimestre.databinding.EquiposBinding

class Equipos : Fragment() {
    private lateinit var binding: EquiposBinding
    private lateinit var equiposAdapter: Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EquiposBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaEquipos = ArrayList<FranNBA>()

        val atlanta = FranNBA(R.drawable.atlanta,"Atlanta","Hawks")
        val boston = FranNBA(R.drawable.boston,"Boston","Celtics")
        val atlanta2 = FranNBA(R.drawable.atlanta,"Atlanta","Hawks")
        val atlanta3 = FranNBA(R.drawable.atlanta,"Atlanta","Hawks")
        val atlanta4 = FranNBA(R.drawable.atlanta,"Atlanta","Hawks")
        val atlanta5 = FranNBA(R.drawable.atlanta,"Atlanta","Hawks")
        val atlanta6 = FranNBA(R.drawable.atlanta,"Atlanta","Hawks")
        val atlanta7 = FranNBA(R.drawable.atlanta,"Atlanta","Hawks")
        val atlanta8 = FranNBA(R.drawable.atlanta,"Atlanta","Hawks")
        val atlanta9 = FranNBA(R.drawable.atlanta,"Atlanta","Hawks")
        val atlanta10 = FranNBA(R.drawable.atlanta,"Atlanta","Hawks")
        val atlanta11 = FranNBA(R.drawable.atlanta,"Atlanta","Hawks")
        val atlanta12 = FranNBA(R.drawable.atlanta,"Atlanta","Hawks")
        val atlanta13 = FranNBA(R.drawable.atlanta,"Atlanta","Hawks")
        val atlanta14 = FranNBA(R.drawable.atlanta,"Atlanta","Hawks")
        val atlanta15 = FranNBA(R.drawable.atlanta,"Atlanta","Hawks")
        val atlanta16 = FranNBA(R.drawable.atlanta,"Atlanta","Hawks")

        listaEquipos.add(atlanta)
        listaEquipos.add(boston)
        listaEquipos.add(atlanta2)
        listaEquipos.add(atlanta3)
        listaEquipos.add(atlanta4)
        listaEquipos.add(atlanta5)
        listaEquipos.add(atlanta6)
        listaEquipos.add(atlanta7)
        listaEquipos.add(atlanta8)
        listaEquipos.add(atlanta9)
        listaEquipos.add(atlanta10)
        listaEquipos.add(atlanta11)
        listaEquipos.add(atlanta12)
        listaEquipos.add(atlanta13)
        listaEquipos.add(atlanta14)
        listaEquipos.add(atlanta15)
        listaEquipos.add(atlanta16)

        val layoutManager = GridLayoutManager(requireContext(),2)
        equiposAdapter = EquiposAdapter(listaEquipos)

        binding.rvEquipos.layoutManager = layoutManager
        binding.rvEquipos.adapter = equiposAdapter as EquiposAdapter

    }

    private fun obtenerListaEquipos(): List<FranquiciaNBA> {
        val ciudadesEquipos = arrayOf(
            "Atlanta", "Boston", "Brooklyn", "Charlotte", "Chicago",
            "Cleveland", "Dallas", "Denver", "Detroit", "Golden State",
            "Houston", "Indiana", "LA", "Los Angeles", "Memphis",
            "Miami", "Milwaukee", "Minnesota", "New Orleans", "New York",
            "Oklahoma City", "Orlando", "Philadelphia", "Phoenix", "Portland",
            "Sacramento", "San Antonio", "Toronto", "Utah", "Washington"
        )

        val apodosEquipos = arrayOf(
            "Hawks", "Celtics", "Nets", "Hornets", "Bulls",
            "Cavaliers", "Mavericks", "Nuggets", "Pistons", "Warriors",
            "Rockets", "Pacers", "Clippers", "Lakers", "Grizzlies",
            "Heat", "Bucks", "Timberwolves", "Pelicans", "Knicks",
            "Thunder", "Magic", "76ers", "Suns", "Trail Blazers",
            "Kings", "Spurs", "Raptors", "Jazz", "Wizards"
        )

        val idsLogos = intArrayOf(
            R.drawable.atlanta, R.drawable.boston, R.drawable.brooklyn,
            R.drawable.charlotte, R.drawable.chicago, R.drawable.cleveland,
            R.drawable.dallas, R.drawable.denver, R.drawable.pistons,
            R.drawable.golden_state_warriors, R.drawable.houston_rockets_seeklogo, R.drawable.indiana_pacers_seeklogo,
            R.drawable.clippers, R.drawable.lakers, R.drawable.memphis,
            R.drawable.miami, R.drawable.milwakeu, R.drawable.minnesota,
            R.drawable.new_orleans, R.drawable.knicks, R.drawable.okc,
            R.drawable.orlando, R.drawable.phili, R.drawable.phoenix,
            R.drawable.portland, R.drawable.sacramento, R.drawable.san_antonio,
            R.drawable.toronto, R.drawable.utah, R.drawable.wizards
        )

        val listaEquipos = mutableListOf<FranquiciaNBA>()

        for (i in ciudadesEquipos.indices) {
            val equipo = FranquiciaNBA()
            equipo.nombreEquipo = ciudadesEquipos[i]
            equipo.idLogo = idsLogos[i]
            equipo.nickname = "Apodo: ${apodosEquipos[i]}"
            listaEquipos.add(equipo)
        }

        return listaEquipos
    }
}
