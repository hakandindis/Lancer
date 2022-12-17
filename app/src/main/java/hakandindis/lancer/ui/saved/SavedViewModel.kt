package hakandindis.lancer.ui.saved

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hakandindis.lancer.data.local.entity.HeroEntity
import hakandindis.lancer.data.local.entity.TeamEntity
import hakandindis.lancer.data.repository.SavedRepository
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SavedViewModel @Inject constructor(private val savedRepository: SavedRepository) : ViewModel() {

    lateinit var savedHeroes: LiveData<List<HeroEntity>>
    lateinit var savedTeams: LiveData<List<TeamEntity>>

    init {
        getAllSavedHeroes()
        getAllSavedTeams()
    }

    private fun getAllSavedHeroes() = viewModelScope.launch {
        savedHeroes = savedRepository.getAllSavedHeroes()
    }

    private fun getAllSavedTeams() = viewModelScope.launch {
        savedTeams = savedRepository.getAllSavedTeams()
    }

    fun deleteHero(heroEntity: HeroEntity) = viewModelScope.launch {
        savedRepository.deleteHero(heroEntity)
    }
}