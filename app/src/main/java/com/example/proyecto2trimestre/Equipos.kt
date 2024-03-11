package com.example.proyecto2trimestre

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyecto2trimestre.Player;
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto2trimestre.databinding.EquiposBinding


class Equipos : Fragment() {


    private lateinit var binding: EquiposBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EquiposBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


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


    }

}