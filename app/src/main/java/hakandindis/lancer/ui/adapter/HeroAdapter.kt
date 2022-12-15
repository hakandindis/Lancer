package hakandindis.lancer.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hakandindis.lancer.R
import hakandindis.lancer.data.model.Hero
import hakandindis.lancer.databinding.HeroItemBinding

class HeroAdapter : ListAdapter<Hero, HeroViewHolder>(HeroDiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val binding = HeroItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) = holder.bind(currentList[position])
}

class HeroViewHolder(private val binding: HeroItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(hero: Hero) {
        val url = "https://api.opendota.com${hero.img}"

        with(binding) {
            nameText.text = hero.localizedName
            attackTypeText.text = hero.attackType
            Glide.with(heroImg).load(url).into(heroImg)

//            when (hero.primaryAttr) {
//                "str" -> Glide.with(attributeImg).load(R.drawable.strength).into(attributeImg)
//                "agi" -> Glide.with(attributeImg).load(R.drawable.agility).into(attributeImg)
//                "int" -> Glide.with(attributeImg).load(R.drawable.intelligence).into(attributeImg)
//                else -> {}
//            }
        }
    }
}

object HeroDiffUtilCallback : DiffUtil.ItemCallback<Hero>() {
    override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean = oldItem == newItem

}
