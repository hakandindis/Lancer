package hakandindis.lancer.ui.team

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import hakandindis.lancer.R
import hakandindis.lancer.databinding.FragmentTeamBinding
import hakandindis.lancer.extension.viewBinding
import hakandindis.lancer.ui.adapter.TeamAdapter

@AndroidEntryPoint
class TeamFragment : Fragment(R.layout.fragment_team) {

    private val binding by viewBinding(FragmentTeamBinding::bind)
    private val adapter by lazy { TeamAdapter() }
    private val viewModel: TeamViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
        initObservers()
    }

    private fun initViews() {
        binding.teamList.adapter = adapter
    }

    private fun initListeners() {

        adapter.onTeamClicked = {
            viewModel.insertTeam(it)
        }

        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    viewModel.searchTeam(s)
                } else if (count == 0) {
                    viewModel.getAllTeams()
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    private fun initObservers() {
        viewModel.teams.observe(viewLifecycleOwner) {
            if (it != null) adapter.submitList(it)
        }

        viewModel.filteredTeams.observe(viewLifecycleOwner) {
            if (it != null) adapter.submitList(it)
        }
    }
}