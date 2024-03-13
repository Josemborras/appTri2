package com.example.proyecto2trimestre.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto2trimestre.dataClass.Player
import com.example.proyecto2trimestre.databinding.FragmentRosterBinding
import com.example.proyecto2trimestre.databinding.RosterViewBinding

class RosterAdapter(val roster: List<Player>) : RecyclerView.Adapter<RosterAdapter.RosterHolder>() {

    inner class RosterHolder(val binding: RosterViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RosterHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RosterViewBinding.inflate(layoutInflater,parent,false)
        return RosterHolder(binding)
    }

    override fun getItemCount(): Int {
        return roster.size
    }

    override fun onBindViewHolder(holder: RosterHolder, position: Int) {
        val player = roster[position]

        holder.binding.tvPlayer.text = player.name
        holder.binding.tvNum.text = player.number
        holder.binding.tvPosicion.text = player.position
        holder.binding.tvAltura.text = player.height
        holder.binding.tvPeso.text = player.weight
        holder.binding.tvEdad.text = player.age.toString()
        holder.binding.tvExp.text = player.experience.toString()

    }
}
