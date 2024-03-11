package com.example.proyecto2trimestre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto2trimestre.databinding.HolderBinding


class EquipoDetalle: Fragment() {
    private lateinit var binding: HolderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HolderBinding.inflate(inflater, container, false)
        return binding.root


    }


        val bostonR = arrayOf(
            Player("Jayson Tatum", "#0", "F-G", "6-8", "210 lbs", "MAR 03, 1998", 26, 6, "Duke", "#3 Pick in 2017 Draft"),
            Player("Jayson Tatum", "#0", "F-G", "6-8", "210 lbs", "MAR 03, 1998", 26, 6, "Duke", "#3 Pick in 2017 Draft"),
            Player("Jayson Tatum", "#0", "F-G", "6-8", "210 lbs", "MAR 03, 1998", 26, 6, "Duke", "#3 Pick in 2017 Draft"),
            Player("Jayson Tatum", "#0", "F-G", "6-8", "210 lbs", "MAR 03, 1998", 26, 6, "Duke", "#3 Pick in 2017 Draft"),
            Player("Jayson Tatum", "#0", "F-G", "6-8", "210 lbs", "MAR 03, 1998", 26, 6, "Duke", "#3 Pick in 2017 Draft"),
            Player("Jayson Tatum", "#0", "F-G", "6-8", "210 lbs", "MAR 03, 1998", 26, 6, "Duke", "#3 Pick in 2017 Draft"),
            Player("Jayson Tatum", "#0", "F-G", "6-8", "210 lbs", "MAR 03, 1998", 26, 6, "Duke", "#3 Pick in 2017 Draft"),
            Player("Jayson Tatum", "#0", "F-G", "6-8", "210 lbs", "MAR 03, 1998", 26, 6, "Duke", "#3 Pick in 2017 Draft"),
            Player("Jayson Tatum", "#0", "F-G", "6-8", "210 lbs", "MAR 03, 1998", 26, 6, "Duke", "#3 Pick in 2017 Draft"),
            Player("Jayson Tatum", "#0", "F-G", "6-8", "210 lbs", "MAR 03, 1998", 26, 6, "Duke", "#3 Pick in 2017 Draft"),
            Player("Jayson Tatum", "#0", "F-G", "6-8", "210 lbs", "MAR 03, 1998", 26, 6, "Duke", "#3 Pick in 2017 Draft"),
            Player("Jayson Tatum", "#0", "F-G", "6-8", "210 lbs", "MAR 03, 1998", 26, 6, "Duke", "#3 Pick in 2017 Draft"),
            Player("Jayson Tatum", "#0", "F-G", "6-8", "210 lbs", "MAR 03, 1998", 26, 6, "Duke", "#3 Pick in 2017 Draft"),
            Player("Jayson Tatum", "#0", "F-G", "6-8", "210 lbs", "MAR 03, 1998", 26, 6, "Duke", "#3 Pick in 2017 Draft"),
            Player("Jayson Tatum", "#0", "F-G", "6-8", "210 lbs", "MAR 03, 1998", 26, 6, "Duke", "#3 Pick in 2017 Draft"),
            Player("Jayson Tatum", "#0", "F-G", "6-8", "210 lbs", "MAR 03, 1998", 26, 6, "Duke", "#3 Pick in 2017 Draft"),
            Player("Jayson Tatum", "#0", "F-G", "6-8", "210 lbs", "MAR 03, 1998", 26, 6, "Duke", "#3 Pick in 2017 Draft"),

            )


    val recyclerView: RecyclerView = findViewById(R.id.rvRoster)
    val layoutManager = LinearLayoutManager(requireContext())  // o GridLayoutManager si lo prefieres
    recyclerView.layoutManager = layoutManager

    val rosterAdapter = RosterAdapter(bostonR)
    recyclerView.adapter = rosterAdapter


}