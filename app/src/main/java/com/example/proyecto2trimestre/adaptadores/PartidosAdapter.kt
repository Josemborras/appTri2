package com.example.proyecto2trimestre.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto2trimestre.databinding.HolderPartidosBinding

class PartidosAdapter(val galeria: ArrayList<Int>): RecyclerView.Adapter<PartidosAdapter.MyHolder>() {
    inner class MyHolder(val binding: HolderPartidosBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val layoutinflater = LayoutInflater.from(parent.context)
        val binding = HolderPartidosBinding.inflate(layoutinflater, parent, false)

        val layoutCelda = MyHolder(binding)
        return layoutCelda
    }

    override fun getItemCount(): Int {
        return galeria.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val idImagen = galeria[position]
        holder.binding.imageView9.setImageResource(idImagen)
    }

}