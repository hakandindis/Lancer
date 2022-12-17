package hakandindis.lancer.ui.hero

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hakandindis.lancer.data.model.Hero
import hakandindis.lancer.data.repository.HeroRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroViewModel @Inject constructor(private val heroRepository: HeroRepository) : ViewModel() {

    private var _heroes: MutableLiveData<List<Hero>> = MutableLiveData()
    val heroes: LiveData<List<Hero>>
        get() = _heroes

    private var _filteredHeroes: MutableLiveData<List<Hero>?> = MutableLiveData()
    val filteredHeroes: LiveData<List<Hero>?>
        get() = _filteredHeroes

    init {
        getAllHeroes()
    }

    fun getAllHeroes() = viewModelScope.launch {
        _heroes.value = heroRepository.getAllHeroes()
    }

    fun searchHero(filterText: CharSequence) {
        val filteredHeroes = heroes.value?.filter {
            it.localizedName?.lowercase()?.contains(filterText) ?: false
        }

        if (filteredHeroes != null) {
            _filteredHeroes.value = filteredHeroes!!
        }
    }

    fun insertHero(hero: Hero) = viewModelScope.launch {
        heroRepository.insertHero(hero)
    }

}