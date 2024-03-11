import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto2trimestre.Player
import com.example.proyecto2trimestre.R

class RosterAdapter(private val playerList: Array<Player>) :
    RecyclerView.Adapter<RosterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = playerList[position]
        holder.bind(player)
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val playerName: TextView = itemView.findViewById(R.id.tvNombre)
        private val playerNumber: TextView = itemView.findViewById(R.id.tvNum)
        private val playerPosition: TextView = itemView.findViewById(R.id.tvPos)
        private val playerHeight: TextView = itemView.findViewById(R.id.tvHeight)
        private val playerWeight: TextView = itemView.findViewById(R.id.tvWeight)
        private val playerBirth: TextView = itemView.findViewById(R.id.tvBirth)
        private val playerAge: TextView = itemView.findViewById(R.id.tvAge)
        private val playerEXP: TextView = itemView.findViewById(R.id.tvEXP)
        private val playerSchool: TextView = itemView.findViewById(R.id.tvSchool)
        private val playerHA: TextView = itemView.findViewById(R.id.tvHA)

        fun bind(player: Player) {
            playerName.text = player.name
            playerNumber.text = player.number
            playerPosition.text = player.position
            playerHeight.text = player.height
            playerWeight.text = player.weight
            playerBirth.text = player.birthdate
            playerAge.text = player.age.toString()
            playerEXP.text = player.experience.toString()

        }
    }
}
