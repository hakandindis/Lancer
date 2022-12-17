package hakandindis.lancer.ui.saved

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hakandindis.lancer.data.local.entity.HeroEntity
import hakandindis.lancer.data.repository.SavedRepository
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SavedViewModel @Inject constructor(private val savedRepository: SavedRepository) : ViewModel() {

    private var _savedHeroes: MutableLiveData<List<HeroEntity>> = MutableLiveData()
    val savedHeroes: LiveData<List<HeroEntity>>
        get() = _savedHeroes


    init {
        getAllSavedHeroes()
    }

    fun getAllSavedHeroes() = viewModelScope.launch {
        _savedHeroes.value = savedRepository.getAllSavedHeroes()
    }
}