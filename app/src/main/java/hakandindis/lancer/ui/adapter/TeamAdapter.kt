package hakandindis.lancer.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hakandindis.lancer.data.model.Team
import hakandindis.lancer.databinding.TeamItemBinding

class TeamAdapter : ListAdapter<Team, TeamViewHolder>(TeamDiffUtilCallback) {

    var onTeamClicked: (Team) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val binding = TeamItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamViewHolder(binding, onTeamClicked)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) = holder.bind(currentList[position])
}

class TeamViewHolder(private val binding: TeamItemBinding, private val onTeamClicked: (Team) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(team: Team) {

        with(binding) {
            nameText.text = team.name
            winText.text = team.wins.toString()
            Glide.with(teamImg).load(team.logoUrl).into(teamImg)

            root.setOnClickListener { onTeamClicked(team) }
        }
    }
}

object TeamDiffUtilCallback : DiffUtil.ItemCallback<Team>() {
    override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean = (oldItem.teamId == newItem.teamId)

    override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean = (oldItem == newItem)
}