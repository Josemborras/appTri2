import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto2trimestre.FranNBA
import com.example.proyecto2trimestre.databinding.RosterBinding

class RosterAdapter(val franquicia: FranNBA) : RecyclerView.Adapter<RosterAdapter.RosterHolder>() {

    inner class RosterHolder(val binding: RosterBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RosterHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RosterBinding.inflate(layoutInflater,parent,false)
        return RosterHolder(binding)
    }

    override fun getItemCount(): Int {
        return franquicia.roster.size
    }

    override fun onBindViewHolder(holder: RosterHolder, position: Int) {
        val player = franquicia.roster[position]
        //holder.binding.tvNomPlayer.text = player.name
        //holder.binding.tvNumero.text = player.number
        holder.binding.imageView6.setImageResource(franquicia.logo)
        holder.binding.tvTitulos.text = franquicia.titulos.toString()

    }
}
