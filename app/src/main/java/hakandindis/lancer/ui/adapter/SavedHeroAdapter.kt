package hakandindis.lancer.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hakandindis.lancer.data.local.entity.HeroEntity
import hakandindis.lancer.data.model.Team
import hakandindis.lancer.databinding.SavedHeroItemBinding

class SavedHeroAdapter : ListAdapter<HeroEntity, SavedHolder>(SavedHeroDiffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: SavedHolder, position: Int) {
        TODO("Not yet implemented")
    }
}

class SavedHolder(private val binding: SavedHeroItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(team: Team) {

    }
}

object SavedHeroDiffUtilCallback : DiffUtil.ItemCallback<HeroEntity>() {
    override fun areItemsTheSame(oldItem: HeroEntity, newItem: HeroEntity): Boolean = (oldItem.id == newItem.id)

    override fun areContentsTheSame(oldItem: HeroEntity, newItem: HeroEntity): Boolean = (oldItem == newItem)

}