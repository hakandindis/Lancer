package hakandindis.lancer.data.repository

import hakandindis.lancer.data.local.dao.HeroDao
import hakandindis.lancer.data.model.Hero
import hakandindis.lancer.data.remote.HeroService
import javax.inject.Inject

class HeroRepository @Inject constructor(
    private val heroService: HeroService,
    private val heroDao: HeroDao
) {

    suspend fun getAllHeroes() = heroService.getAllHeroes()

    suspend fun insertHero(hero: Hero) = heroDao.insertHero(hero.toEntity())

}