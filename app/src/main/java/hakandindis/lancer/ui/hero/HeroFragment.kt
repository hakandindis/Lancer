package hakandindis.lancer.ui.hero

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import hakandindis.lancer.R
import hakandindis.lancer.databinding.FragmentHeroBinding
import hakandindis.lancer.extension.viewBinding
import hakandindis.lancer.ui.adapter.HeroAdapter

@AndroidEntryPoint
class HeroFragment : Fragment(R.layout.fragment_hero) {

    private val binding by viewBinding(FragmentHeroBinding::bind)
    private val adapter by lazy { HeroAdapter() }
    private val viewModel: HeroViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initObservers()
    }

    private fun initViews() {
        binding.heroList.adapter = this.adapter
    }

    private fun initObservers() {
        viewModel.heroes.observe(viewLifecycleOwner) {
            if (it != null) adapter.submitList(it)
        }
    }
}