package hakandindis.lancer.ui.hero

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import hakandindis.lancer.R
import hakandindis.lancer.databinding.FragmentSavedHeroBinding
import hakandindis.lancer.extension.viewBinding
import hakandindis.lancer.ui.adapter.HeroAdapter
import hakandindis.lancer.util.PageType


@AndroidEntryPoint
class SavedHeroFragment : Fragment(R.layout.fragment_saved_hero) {

    private val binding by viewBinding(FragmentSavedHeroBinding::bind)
    private val adapter by lazy { HeroAdapter(PageType.SAVED) }
    private val viewModel: HeroViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
        initObservers()
    }

    private fun initViews() {
        binding.heroList.adapter = adapter
    }

    private fun initListeners() {
        adapter.onHeroClick = {
//            val action = SavedFragmentDirections.savedToHeroDetail(it)
//            findNavController().navigate(action)
        }
    }

    private fun initObservers() {
        viewModel.savedHeroes.observe(viewLifecycleOwner) {
            if (it != null) {
                val value = it.map { it.toModel() }
                adapter.submitList(value)
            }
        }
    }
}