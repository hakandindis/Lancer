package hakandindis.lancer.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hakandindis.lancer.data.local.entity.TeamEntity
import hakandindis.lancer.databinding.TeamItemBinding

class SavedTeamAdapter : ListAdapter<TeamEntity, SavedTeamViewHolder>(SavedTeamDiffUtilCallback) {

    var onSavedTeamClicked: (TeamEntity) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedTeamViewHolder {
        val binding = TeamItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SavedTeamViewHolder(binding, onSavedTeamClicked)
    }

    override fun onBindViewHolder(holder: SavedTeamViewHolder, position: Int) = holder.bind(currentList[position])
}

class SavedTeamViewHolder(private val binding: TeamItemBinding, private val onSavedTeamClicked: (TeamEntity) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(team: TeamEntity) {

        with(binding) {
            nameText.text = team.name
            winText.text = team.wins.toString()
            Glide.with(teamImg).load(team.logoUrl).into(teamImg)

            root.setOnClickListener { onSavedTeamClicked(team) }
        }
    }
}

object SavedTeamDiffUtilCallback : DiffUtil.ItemCallback<TeamEntity>() {
    override fun areItemsTheSame(oldItem: TeamEntity, newItem: TeamEntity): Boolean = (oldItem.teamId == newItem.teamId)

    override fun areContentsTheSame(oldItem: TeamEntity, newItem: TeamEntity): Boolean = (oldItem == newItem)
}