package com.example.proyecto2trimestre

import RosterAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.GridLayoutManager
import com.example.proyecto2trimestre.databinding.RosterBinding


class RosterFragment : Fragment() {
    private lateinit var binding: RosterBinding
    private lateinit var rosterAdapter: Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RosterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val atlanta = FranNBA(R.drawable.atlanta,"Atlanta","Hawks", 0,"este", roster = bostonR)
        val dallas = FranNBA(R.drawable.dallas,"Dallas","Mavericks",1, "oeste", roster = bostonR)
        val boston = FranNBA(R.drawable.boston,"Boston","Celtics",17, "este" , roster = bostonR)
        val denver = FranNBA(R.drawable.denver,"Denver","Nuggets", 1,"oeste", roster = bostonR)
        val brooklyn = FranNBA(R.drawable.brooklyn,"Brooklyn","Nets", 0,"este", roster = bostonR)
        val golden = FranNBA(R.drawable.golden_state_warriors,"Golden State","Warriors",7, "oeste", roster = bostonR)
        val charlotte = FranNBA(R.drawable.charlotte,"Charlotte","Hornets",0, "este", roster = bostonR)
        val houston = FranNBA(R.drawable.houston_rockets_seeklogo,"Houston","Rockets",2, "oeste", roster = bostonR)
        val chicago = FranNBA(R.drawable.chicago,"Chicago","Bulls",6, "este", roster = bostonR)
        val clippers = FranNBA(R.drawable.clippers,"LA","Clippers",0, "oeste", roster = bostonR)
        val cleveland = FranNBA(R.drawable.cleveland,"Cleveland","Cavaliers",1, "este", roster = bostonR)
        val lakers = FranNBA(R.drawable.lakers,"Los Angeles","Lakers",17, "oeste", roster = bostonR)
        val detroit = FranNBA(R.drawable.pistons,"Detroit","Pistons", 3,"este", roster = bostonR)
        val memphis = FranNBA(R.drawable.memphis,"Memphis","Grizzlies",0, "oeste", roster = bostonR)
        val indiana = FranNBA(R.drawable.indiana_pacers_seeklogo,"Indiana","Pacers",0, "este", roster = bostonR)
        val minesota = FranNBA(R.drawable.minnesota,"Minnesota","Timberwolves",0, "oeste", roster = bostonR)
        val miami = FranNBA(R.drawable.miami,"Miami","Heat",3,"este", roster = bostonR)
        val newOrleans = FranNBA(R.drawable.new_orleans,"New Orleans","Pelicans",0, "oeste", roster = bostonR)
        val milwaukee = FranNBA(R.drawable.milwakeu,"Milwaukee","Bucks",2, "este", roster = bostonR)
        val oklahoma = FranNBA(R.drawable.okc,"Oklahoma City","Thunder",0, "oeste", roster = bostonR)
        val newYork = FranNBA(R.drawable.knicks,"New York","Knicks",2, "este", roster = bostonR)
        val phoenix = FranNBA(R.drawable.phoenix,"Phoenix","Suns",0, "oeste", roster = bostonR)
        val orlando = FranNBA(R.drawable.orlando,"Orlando","Magic",0, "este", roster = bostonR)
        val portland = FranNBA(R.drawable.portland,"Portland","Trail Blazzers",0, "oeste", roster = bostonR)
        val phili = FranNBA(R.drawable.phili,"Philadelphia","76ers",2, "este", roster = bostonR)
        val sacramento = FranNBA(R.drawable.sacramento,"Sacramento","Kings",0, "oeste", roster = bostonR)
        val toronto = FranNBA(R.drawable.toronto,"Toronto","Raptors",1, "este", roster = bostonR)
        val sanAntonio = FranNBA(R.drawable.san_antonio,"San Antonio","Spurs",5, "oeste", roster = bostonR)
        val washington = FranNBA(R.drawable.wizards,"Washington","Wizards",1, "este", roster = bostonR)
        val utah = FranNBA(R.drawable.utah,"Utah","Jazz",0, "oeste", roster = bostonR)

        val layoutManager = GridLayoutManager(requireContext(),2)
        rosterAdapter = RosterAdapter()

        binding.rvEquipos.layoutManager = layoutManager
        binding.rvEquipos.adapter = equiposAdapter as EquiposAdapter

    }
}