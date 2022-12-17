package hakandindis.lancer.ui.hero

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import hakandindis.lancer.R
import hakandindis.lancer.databinding.FragmentHeroDetailBinding
import hakandindis.lancer.extension.viewBinding


class HeroDetailFragment : Fragment(R.layout.fragment_hero_detail) {

    private val binding by viewBinding(FragmentHeroDetailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}