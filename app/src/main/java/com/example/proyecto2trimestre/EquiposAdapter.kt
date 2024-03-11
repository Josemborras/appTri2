package com.example.proyecto2trimestre

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.helper.widget.Carousel
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

import com.example.proyecto2trimestre.databinding.HolderBinding


class EquiposAdapter(val listaEquipos: ArrayList<FranNBA>) : Adapter<EquiposAdapter.Clase>(),
    Carousel.Adapter {

    inner class Clase(val binding: HolderBinding) : ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Clase {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HolderBinding.inflate(layoutInflater,parent,false)
        return Clase(binding)
    }

    override fun getItemCount(): Int {
        return listaEquipos.size
    }

    override fun onBindViewHolder(holder: Clase, position: Int) {
        val equipo = listaEquipos[position]

        with(holder.binding){
            tvNombreEquipo.text = equipo.nombre
            tvNickEquipo.text = equipo.nick


        }

        Glide.with(holder.itemView)
            .load(equipo.logo)
            .into(holder.binding.ivLogoEquipo)
    }

    override fun count(): Int {
        TODO("Not yet implemented")
    }

    override fun populate(view: View?, index: Int) {
        TODO("Not yet implemented")
    }

    override fun onNewItem(index: Int) {
        TODO("Not yet implemented")
    }
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
