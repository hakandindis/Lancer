package hakandindis.lancer.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import hakandindis.lancer.ui.hero.HeroFragment
import hakandindis.lancer.ui.team.TeamFragment
import hakandindis.lancer.util.PageType

const val PAGE_COUNT = 2

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, private val pageType: PageType) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = PAGE_COUNT

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) HeroFragment.newInstance(pageType)
        else TeamFragment.newInstance(pageType)
    }
}