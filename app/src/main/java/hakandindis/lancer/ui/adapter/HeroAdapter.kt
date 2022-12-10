package hakandindis.lancer.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hakandindis.lancer.data.model.Hero
import hakandindis.lancer.databinding.HeroItemBinding

class HeroAdapter : ListAdapter<Hero, HeroViewHolder>(HeroDiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}

class HeroViewHolder(private val binding: HeroItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(hero: Hero) {

    }
}

object HeroDiffUtilCallback : DiffUtil.ItemCallback<Hero>() {
    override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean = oldItem == newItem

}
