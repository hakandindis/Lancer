package hakandindis.lancer.data.remote

import hakandindis.lancer.data.model.Hero
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroService {

    @GET(ALL_HEROES)
    suspend fun getAllHeroes(): List<Hero>


    companion object {
        const val ALL_HEROES = "heroStats"
    }
}