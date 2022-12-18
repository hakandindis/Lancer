package hakandindis.lancer.ui.hero

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import hakandindis.lancer.R
import hakandindis.lancer.databinding.FragmentHeroDetailBinding
import hakandindis.lancer.extension.viewBinding

@AndroidEntryPoint
class HeroDetailFragment : Fragment(R.layout.fragment_hero_detail) {

    private val binding by viewBinding(FragmentHeroDetailBinding::bind)
    private val viewModel: HeroViewModel by viewModels()
    private val args: HeroDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
    }

    private fun initViews() {
        with(binding) {
            args.hero.let {
                val url = "https://api.opendota.com${it.img}"

                nameText.text = it.localizedName
                attackTypeText.text = it.attackType
                Glide.with(heroImg).load(url).into(heroImg)

                when (it.primaryAttr) {
                    "str" -> Glide.with(primaryAttributeImg).load(R.drawable.strength).into(primaryAttributeImg)
                    "agi" -> Glide.with(primaryAttributeImg).load(R.drawable.agility).into(primaryAttributeImg)
                    "int" -> Glide.with(primaryAttributeImg).load(R.drawable.intelligence).into(primaryAttributeImg)
                    else -> {}
                }

                it.roles.let { roles ->
                    if (roles[0] != null) {
                        firstRoleText.text = roles[0]
                    } else {
                        firstRoleCard.visibility = View.INVISIBLE
                    }

                    if (roles.size >= 2 && roles[1] != null) {
                        secondRoleText.text = roles[1]
                    } else {
                        secondRoleCard.visibility = View.INVISIBLE
                    }

                    if (roles.size >= 3 && roles[2] != null) {
                        thirdRoleText.text = roles[2]
                    } else {
                        thirdRoleCard.visibility = View.INVISIBLE
                    }


                }
            }
        }
    }

    private fun initListeners() {
        binding.saveButton.setOnClickListener {
            viewModel.insertHero(args.hero)
        }
    }

}