package projeto.pdm.terceiraprova.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import projeto.pdm.terceiraprova.R
import projeto.pdm.terceiraprova.model.Pokemon

class RecyclerPoke(private val items: List<Pokemon?>
) : RecyclerView.Adapter<RecyclerPoke.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Pokemon?) = with(itemView) {
            val ivPokemon = findViewById<ImageView>(R.id.ivPoke)
            val tvNumber = findViewById<TextView>(R.id.tvNumber)
            val tvName = findViewById<TextView>(R.id.tvName)


            item?.let {
                Glide.with(itemView.context).load(it.imageUrl).into(ivPokemon)
                tvNumber.text = "Nº ${item.formattedNumber}"
                tvName.text = item.formattedName
            }
        }
    }
}