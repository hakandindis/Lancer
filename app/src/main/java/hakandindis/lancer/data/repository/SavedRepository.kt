package hakandindis.lancer.data.repository

import hakandindis.lancer.data.local.dao.HeroDao
import hakandindis.lancer.data.local.entity.HeroEntity
import javax.inject.Inject

class SavedRepository @Inject constructor(
    private val heroDao: HeroDao
) {

    fun getAllSavedHeroes() = heroDao.getAllHeroes()

    suspend fun deleteHero(heroEntity: HeroEntity) = heroDao.deleteHero(heroEntity)
}