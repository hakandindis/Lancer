package hakandindis.lancer.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import hakandindis.lancer.R
import hakandindis.lancer.databinding.FragmentHomeBinding
import hakandindis.lancer.extension.viewBinding
import hakandindis.lancer.ui.adapter.ViewPagerAdapter
import hakandindis.lancer.util.PageType

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        viewPagerAdapter = ViewPagerAdapter(childFragmentManager, lifecycle, PageType.HOME)
        binding.viewPager.adapter = viewPagerAdapter

        val names = listOf("Heroes", "Teams")
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = names[position]
        }.attach()
    }
}