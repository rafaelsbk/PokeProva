package projeto.pdm.terceiraprova.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import projeto.pdm.terceiraprova.R
import projeto.pdm.terceiraprova.model.Pokemon

class AdapterPoke(private val items: List<Pokemon>
) : RecyclerView.Adapter<AdapterPoke.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindView(item: Pokemon) = with(itemView){
            val ivPokemon = findViewById<ImageView>(R.id.ivPoke)
            val tvName = findViewById<TextView>(R.id.tvName)
            val tvNumber = findViewById<TextView>(R.id.tvNumber)

            // TODO: Load imagem with Glide

            tvNumber.text = "${item.number}"
            tvName.text = item.name
        }
    }
}