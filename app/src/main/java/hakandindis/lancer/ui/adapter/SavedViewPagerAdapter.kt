package hakandindis.lancer.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import hakandindis.lancer.ui.hero.SavedHeroFragment
import hakandindis.lancer.ui.team.TeamFragment

const val PAGE_COUNT = 2

class SavedViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = PAGE_COUNT

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) SavedHeroFragment()
        else TeamFragment()
    }
}