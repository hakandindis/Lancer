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

    init {
        getAllHeroes()
    }

    fun getAllHeroes() = viewModelScope.launch {
        _heroes.value = heroRepository.getAllHeroes()
    }

}