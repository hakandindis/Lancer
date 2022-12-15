package hakandindis.lancer.ui.saved

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import hakandindis.lancer.R
import hakandindis.lancer.databinding.FragmentSavedBinding
import hakandindis.lancer.extension.viewBinding

@AndroidEntryPoint
class SavedFragment : Fragment(R.layout.fragment_saved) {

    private val binding by viewBinding(FragmentSavedBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}