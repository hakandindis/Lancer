package hakandindis.lancer.ui.team

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import hakandindis.lancer.R
import hakandindis.lancer.databinding.FragmentTeamBinding
import hakandindis.lancer.extension.viewBinding

@AndroidEntryPoint
class TeamFragment : Fragment(R.layout.fragment_team) {

    private val binding by viewBinding(FragmentTeamBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}