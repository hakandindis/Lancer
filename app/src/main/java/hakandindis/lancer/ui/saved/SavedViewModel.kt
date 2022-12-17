package hakandindis.lancer.ui.saved

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hakandindis.lancer.data.local.entity.HeroEntity
import hakandindis.lancer.data.repository.SavedRepository
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SavedViewModel @Inject constructor(private val savedRepository: SavedRepository) : ViewModel() {

    lateinit var savedHeroes: LiveData<List<HeroEntity>>


    init {
        getAllSavedHeroes()
    }

    fun getAllSavedHeroes() = viewModelScope.launch {
        savedHeroes = savedRepository.getAllSavedHeroes()
    }
}