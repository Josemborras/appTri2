package com.example.proyecto2trimestre.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.helper.widget.Carousel
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.proyecto2trimestre.dataClass.FranNBA
import com.example.proyecto2trimestre.dataClass.Player
import com.example.proyecto2trimestre.R
import com.example.proyecto2trimestre.databinding.HolderEquiposBinding


class EquiposAdapter(val listaEquipos: ArrayList<FranNBA>) : Adapter<EquiposAdapter.Clase>(),
    Carousel.Adapter {

    inner class Clase(val binding: HolderEquiposBinding) : ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Clase {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HolderEquiposBinding.inflate(layoutInflater,parent,false)
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



        holder.itemView.setOnClickListener {
            val bundle = bundleOf("equipo" to equipo)
            Navigation.findNavController(holder.itemView).navigate(R.id.action_equipos_to_rosterFragment, bundle)
        }
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

    interface OnTeamClickListener {
        fun onTeamClick(team: FranNBA)
    }


}
