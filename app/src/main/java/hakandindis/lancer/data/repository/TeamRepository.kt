package hakandindis.lancer.data.repository

import hakandindis.lancer.data.remote.TeamService
import javax.inject.Inject

class TeamRepository @Inject constructor(private val teamService: TeamService) {

    suspend fun getAllTeams() = teamService.getAllTeams()
}