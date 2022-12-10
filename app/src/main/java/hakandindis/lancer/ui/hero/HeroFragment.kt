package hakandindis.lancer.ui.hero

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import hakandindis.lancer.R
import hakandindis.lancer.databinding.FragmentHeroBinding
import hakandindis.lancer.extension.viewBinding


class HeroFragment : Fragment(R.layout.fragment_hero) {

    private val binding by viewBinding(FragmentHeroBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}