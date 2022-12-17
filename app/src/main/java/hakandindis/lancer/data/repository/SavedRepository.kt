package hakandindis.lancer.data.repository

import hakandindis.lancer.data.local.dao.HeroDao
import javax.inject.Inject

class SavedRepository @Inject constructor(
    private val heroDao: HeroDao
) {

    fun getAllSavedHeroes() = heroDao.getAllHeroes()
}