package hakandindis.lancer.data.remote

import hakandindis.lancer.data.model.Team
import retrofit2.http.GET
import retrofit2.http.Path

interface TeamService {

    @GET(ALL_TEAMS)
    suspend fun getAllTeams(): List<Team>

    @GET(SINGLE_TEAM)
    suspend fun getSingleTeam(@Path("team_id") teamId: String): Team


    companion object {
        const val ALL_TEAMS = "teams"
        const val SINGLE_TEAM = "teams/{team_id}"
    }
}