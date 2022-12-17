package hakandindis.lancer.data.repository

import hakandindis.lancer.data.local.dao.HeroDao
import hakandindis.lancer.data.model.Hero
import hakandindis.lancer.data.remote.HeroService
import hakandindis.lancer.util.modelToEntity
import javax.inject.Inject

class HeroRepository @Inject constructor(
    private val heroService: HeroService,
    private val heroDao: HeroDao
) {

    suspend fun getAllHeroes() = heroService.getAllHeroes()

    suspend fun insertHero(hero: Hero) {
        val heroEntity = modelToEntity(hero)
        heroDao.insertHero(heroEntity)
    }

    suspend fun getAllSavedHeroes() = heroDao.getAllHeroes()
}