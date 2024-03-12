package com.example.proyecto2trimestre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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

        val atlanta = FranNBA(R.drawable.atlanta,"Atlanta","Hawks", "este")
        val dallas = FranNBA(R.drawable.dallas,"Dallas","Mavericks", "oeste")
        val boston = FranNBA(R.drawable.boston,"Boston","Celtics", "este" )
        val denver = FranNBA(R.drawable.denver,"Denver","Nuggets", "oeste")
        val brooklyn = FranNBA(R.drawable.brooklyn,"Brooklyn","Nets", "este")
        val golden = FranNBA(R.drawable.golden_state_warriors,"Golden State","Warriors", "oeste")
        val charlotte = FranNBA(R.drawable.charlotte,"Charlotte","Hornets", "este")
        val houston = FranNBA(R.drawable.houston_rockets_seeklogo,"Houston","Rockets", "oeste")
        val chicago = FranNBA(R.drawable.chicago,"Chicago","Bulls", "este")
        val clippers = FranNBA(R.drawable.clippers,"LA","Clippers", "oeste")
        val cleveland = FranNBA(R.drawable.cleveland,"Cleveland","Cavaliers", "este")
        val lakers = FranNBA(R.drawable.lakers,"Los Angeles","Lakers", "oeste")
        val detroit = FranNBA(R.drawable.pistons,"Detroit","Pistons", "este")
        val memphis = FranNBA(R.drawable.memphis,"Memphis","Grizzlies", "oeste")
        val indiana = FranNBA(R.drawable.indiana_pacers_seeklogo,"Indiana","Pacers", "este")
        val minesota = FranNBA(R.drawable.minnesota,"Minnesota","Timberwolves", "oeste")
        val miami = FranNBA(R.drawable.miami,"Miami","Heat", "este")
        val newOrleans = FranNBA(R.drawable.new_orleans,"New Orleans","Pelicans", "oeste")
        val milwaukee = FranNBA(R.drawable.milwakeu,"Milwaukee","Bucks", "este")
        val oklahoma = FranNBA(R.drawable.okc,"Oklahoma City","Thunder", "oeste")
        val newYork = FranNBA(R.drawable.knicks,"New York","Knicks", "este")
        val phoenix = FranNBA(R.drawable.phoenix,"Phoenix","Suns", "oeste")
        val orlando = FranNBA(R.drawable.orlando,"Orlando","Magic", "este")
        val portland = FranNBA(R.drawable.portland,"Portland","Trail Blazzers", "oeste")
        val phili = FranNBA(R.drawable.phili,"Philadelphia","76ers", "este")
        val sacramento = FranNBA(R.drawable.sacramento,"Sacramento","Kings", "oeste")
        val toronto = FranNBA(R.drawable.toronto,"Toronto","Raptors", "este")
        val sanAntonio = FranNBA(R.drawable.san_antonio,"San Antonio","Spurs", "oeste")
        val washington = FranNBA(R.drawable.wizards,"Washington","Wizards", "este")
        val utah = FranNBA(R.drawable.utah,"Utah","Jazz", "oeste")

        listaEquipos.add(dallas)
        listaEquipos.add(atlanta)
        listaEquipos.add(denver)
        listaEquipos.add(boston)
        listaEquipos.add(golden)
        listaEquipos.add(brooklyn)
        listaEquipos.add(houston)
        listaEquipos.add(charlotte)
        listaEquipos.add(clippers)
        listaEquipos.add(chicago)
        listaEquipos.add(lakers)
        listaEquipos.add(cleveland)
        listaEquipos.add(memphis)
        listaEquipos.add(detroit)
        listaEquipos.add(minesota)
        listaEquipos.add(indiana)
        listaEquipos.add(newOrleans)
        listaEquipos.add(miami)
        listaEquipos.add(oklahoma)
        listaEquipos.add(milwaukee)
        listaEquipos.add(phoenix)
        listaEquipos.add(newYork)
        listaEquipos.add(portland)
        listaEquipos.add(orlando)
        listaEquipos.add(sacramento)
        listaEquipos.add(phili)
        listaEquipos.add(sanAntonio)
        listaEquipos.add(toronto)
        listaEquipos.add(utah)
        listaEquipos.add(washington)


        val layoutManager = GridLayoutManager(requireContext(),2)
        equiposAdapter = EquiposAdapter(listaEquipos)

        binding.rvEquipos.layoutManager = layoutManager
        binding.rvEquipos.adapter = equiposAdapter as EquiposAdapter

    }
}


