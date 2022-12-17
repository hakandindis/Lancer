package hakandindis.lancer.ui.saved

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import hakandindis.lancer.R
import hakandindis.lancer.databinding.FragmentSavedBinding
import hakandindis.lancer.extension.viewBinding
import hakandindis.lancer.ui.adapter.SavedHeroAdapter

@AndroidEntryPoint
class SavedFragment : Fragment(R.layout.fragment_saved) {

    private val binding by viewBinding(FragmentSavedBinding::bind)
    private val adapter by lazy { SavedHeroAdapter() }
    private val viewModel: SavedViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
    }

    private fun initViews() {
        binding.heroList.adapter = adapter
    }

    private fun initObservers() {
        viewModel.savedHeroes.observe(viewLifecycleOwner) {
            if (it != null) adapter.submitList(it)
        }
    }
}