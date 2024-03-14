package com.example.proyecto2trimestre.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto2trimestre.databinding.HolderDeslizanteBinding


class DeslizanteAdapter (val galeria: ArrayList<Int>): RecyclerView.Adapter<DeslizanteAdapter.MiCelda>() {
    inner class MiCelda(val binding: HolderDeslizanteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiCelda {
        val layoutinflater = LayoutInflater.from(parent.context)
        val binding = HolderDeslizanteBinding.inflate(layoutinflater, parent, false)

        return MiCelda(binding)
    }

    override fun onBindViewHolder(holder: MiCelda, position: Int) {
        val idImagen = galeria[position]
        holder.binding.imageView10.setImageResource(idImagen)
    }


    override fun getItemCount(): Int {
        return galeria.size
    }

}