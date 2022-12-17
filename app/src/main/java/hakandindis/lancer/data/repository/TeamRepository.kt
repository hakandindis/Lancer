package hakandindis.lancer.data.repository

import hakandindis.lancer.data.local.dao.TeamDao
import hakandindis.lancer.data.remote.TeamService
import javax.inject.Inject

class TeamRepository @Inject constructor(
    private val teamService: TeamService,
    private val teamDao: TeamDao
) {

    suspend fun getAllTeams() = teamService.getAllTeams()
}