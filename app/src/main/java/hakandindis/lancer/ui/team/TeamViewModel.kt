package hakandindis.lancer.ui.team

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hakandindis.lancer.data.local.entity.TeamEntity
import hakandindis.lancer.data.model.Team
import hakandindis.lancer.data.repository.TeamRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(private val teamRepository: TeamRepository) : ViewModel() {

    private var _teams: MutableLiveData<List<Team>> = MutableLiveData()
    val teams: LiveData<List<Team>>
        get() = _teams

    private var _filteredTeams: MutableLiveData<List<Team>> = MutableLiveData()
    val filteredTeams: LiveData<List<Team>>
        get() = _filteredTeams

    lateinit var savedTeams: LiveData<List<TeamEntity>>

    private var _filteredSavedTeams: MutableLiveData<List<TeamEntity>> = MutableLiveData()
    val filteredSavedTeams: LiveData<List<TeamEntity>>
        get() = _filteredSavedTeams


    fun getAllTeams() = viewModelScope.launch {
        _teams.value = teamRepository.getAllTeams()
    }

    fun getAllSavedTeams() {
        savedTeams = teamRepository.getAllSavedTeams()
    }

    fun searchTeam(filterText: CharSequence) {
        val filteredTeams = teams.value?.filter {
            it.name?.lowercase()?.contains(filterText) ?: false
        }

        if (filteredTeams != null) _filteredTeams.value = filteredTeams!!
    }

    fun searchSavedTeam(filterText: CharSequence) {
        val filteredTeams = savedTeams.value?.filter {
            it.name?.lowercase()?.contains(filterText) ?: false
        }

//        if (filteredTeams != null)
    }

    fun insertTeam(team: Team) = viewModelScope.launch {
        teamRepository.insertTeam(team)
    }
}