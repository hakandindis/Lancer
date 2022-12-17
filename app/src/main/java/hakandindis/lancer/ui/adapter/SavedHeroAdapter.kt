package hakandindis.lancer.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hakandindis.lancer.data.local.entity.HeroEntity
import hakandindis.lancer.databinding.SavedHeroItemBinding

class SavedHeroAdapter : ListAdapter<HeroEntity, SavedViewHolder>(SavedHeroDiffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedViewHolder {
        val binding = SavedHeroItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SavedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedViewHolder, position: Int) = holder.bind(currentList[position])

}

class SavedViewHolder(private val binding: SavedHeroItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(hero: HeroEntity) {
        val url = "https://api.opendota.com${hero.img}"

        with(binding) {
            nameText.text = hero.name
            attackTypeText.text = hero.attackType
            Glide.with(heroImg).load(url).into(heroImg)

            hero.roles?.let {
                if (hero.roles[0] != null) firstRoleText.text = hero.roles[0]
                if (hero.roles[1] != null) secondRoleText.text = hero.roles[1]
            }

//            when (hero.primaryAttr) {
//                "str" -> Glide.with(attributeImg).load(R.drawable.strength).into(attributeImg)
//                "agi" -> Glide.with(attributeImg).load(R.drawable.agility).into(attributeImg)
//                "int" -> Glide.with(attributeImg).load(R.drawable.intelligence).into(attributeImg)
//                else -> {}
//            }
        }
    }
}

object SavedHeroDiffUtilCallback : DiffUtil.ItemCallback<HeroEntity>() {
    override fun areItemsTheSame(oldItem: HeroEntity, newItem: HeroEntity): Boolean = (oldItem.id == newItem.id)

    override fun areContentsTheSame(oldItem: HeroEntity, newItem: HeroEntity): Boolean = (oldItem == newItem)

}