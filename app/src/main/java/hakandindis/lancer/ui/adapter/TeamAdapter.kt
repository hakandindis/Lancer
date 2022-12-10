package hakandindis.lancer.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hakandindis.lancer.data.model.Team
import hakandindis.lancer.databinding.TeamItemBinding

class TeamAdapter : ListAdapter<Team, TeamViewHolder>(TeamDiffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}

class TeamViewHolder(private val binding: TeamItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(team: Team) {

    }
}

object TeamDiffUtilCallback : DiffUtil.ItemCallback<Team>() {
    override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean = (oldItem.teamId == newItem.teamId)

    override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean = (oldItem == newItem)

}