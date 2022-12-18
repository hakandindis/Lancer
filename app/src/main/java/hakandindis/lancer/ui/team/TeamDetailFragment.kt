package hakandindis.lancer.ui.team

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import hakandindis.lancer.R
import hakandindis.lancer.databinding.FragmentTeamDetailBinding
import hakandindis.lancer.extension.viewBinding

@AndroidEntryPoint
class TeamDetailFragment : Fragment(R.layout.fragment_team_detail) {

    private val binding by viewBinding(FragmentTeamDetailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}