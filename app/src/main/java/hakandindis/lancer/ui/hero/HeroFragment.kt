package hakandindis.lancer.ui.hero

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import hakandindis.lancer.R
import hakandindis.lancer.databinding.FragmentHeroBinding
import hakandindis.lancer.extension.viewBinding
import hakandindis.lancer.ui.adapter.HeroAdapter
import hakandindis.lancer.util.PAGE_TYPE
import hakandindis.lancer.util.PageType

@AndroidEntryPoint
class HeroFragment : Fragment(R.layout.fragment_hero) {

    private val binding by viewBinding(FragmentHeroBinding::bind)
    private val viewModel: HeroViewModel by viewModels()
    private lateinit var adapter: HeroAdapter
    private lateinit var pageType: PageType

    companion object {
        @JvmStatic
        fun newInstance(pageType: PageType) = HeroFragment().apply {
            arguments = Bundle().apply {
                putSerializable(PAGE_TYPE, pageType)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null && requireArguments().containsKey(PAGE_TYPE)) {
            pageType = requireArguments().getSerializable(PAGE_TYPE) as PageType
        }

        when (pageType) {
            PageType.HOME -> viewModel.getAllHeroes()
            PageType.SAVED -> viewModel.getAllSavedHeroes()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
        initObservers()
    }

    private fun initViews() {
        adapter = HeroAdapter(pageType)
        binding.heroList.adapter = this.adapter
    }

    private fun initListeners() {

        adapter.onHeroClick = {
            val action = HeroFragmentDirections.heroToDetail(it)
            findNavController().navigate(action)
        }

        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    viewModel.searchHero(s)
                } else if (count == 0) {
                    viewModel.getAllHeroes()
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    private fun initObservers() {
        viewModel.heroes.observe(viewLifecycleOwner) {
            if (it != null) adapter.submitList(it)
        }

        viewModel.filteredHeroes.observe(viewLifecycleOwner) {
            if (it != null) adapter.submitList(it)
        }
    }
}