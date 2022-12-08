package hakandindis.lancer.data.remote

import hakandindis.lancer.data.model.Team
import retrofit2.http.GET

interface TeamService {

    @GET(ALL_TEAM)
    suspend fun getAllTeams(): List<Team>


    companion object {
        const val ALL_TEAM = "teams"
    }
}