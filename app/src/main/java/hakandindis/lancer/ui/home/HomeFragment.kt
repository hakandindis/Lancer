package hakandindis.lancer.ui.home

import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import hakandindis.lancer.R
import hakandindis.lancer.databinding.FragmentHomeBinding
import hakandindis.lancer.extension.viewBinding

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

}