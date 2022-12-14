package hakandindis.lancer.ui.saved

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import hakandindis.lancer.R
import hakandindis.lancer.databinding.FragmentSavedBinding
import hakandindis.lancer.extension.viewBinding
import hakandindis.lancer.ui.adapter.ViewPagerAdapter
import hakandindis.lancer.util.PageType

@AndroidEntryPoint
class SavedFragment : Fragment(R.layout.fragment_saved) {

    private val binding by viewBinding(FragmentSavedBinding::bind)

    private val viewModel: SavedViewModel by viewModels()
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
        initObservers()
    }

    private fun initViews() {
        viewPagerAdapter = ViewPagerAdapter(childFragmentManager, lifecycle, PageType.SAVED)
        binding.viewPager.adapter = viewPagerAdapter

        val names = listOf("Heroes", "Teams")
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = names[position]
        }.attach()
    }

    private fun initListeners() {
//        adapter.onSavedHeroClick = {
//            MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme)
//                .setTitle("Silmek istediğinize emin misiniz?")
//                .setMessage("Bu işlem geri alınamaz ancak daha sonrasında bu kahramanı tekrar kaydedebilirsiniz")
//                .setNegativeButton("Vazgeç") { dialog, which ->
//                    dialog.cancel()
//                }
//                .setPositiveButton("Sil") { dialog, which ->
//                    viewModel.deleteHero(it)
//                    dialog.cancel()
//                }
//                .show()
//        }
    }

    private fun initObservers() {
//        viewModel.savedHeroes.observe(viewLifecycleOwner) {
//            if (it != null) adapter.submitList(it)
//        }

        viewModel.savedTeams.observe(viewLifecycleOwner) {
            if (it != null) {
                it.forEach { team ->
                    Log.d("SAVED-TEAM", team.toString())
                }
                Log.d("SAVED-TEAM", "-------------------------------------------------------------------------")
            }
        }
    }
}