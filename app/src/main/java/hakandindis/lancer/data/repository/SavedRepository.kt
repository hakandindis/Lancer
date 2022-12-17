package hakandindis.lancer.data.repository

import hakandindis.lancer.data.local.dao.HeroDao
import hakandindis.lancer.data.local.dao.TeamDao
import hakandindis.lancer.data.local.entity.HeroEntity
import hakandindis.lancer.data.local.entity.TeamEntity
import javax.inject.Inject

class SavedRepository @Inject constructor(
    private val heroDao: HeroDao,
    private val teamDao: TeamDao
) {

    fun getAllSavedHeroes() = heroDao.getAllHeroes()
    fun getAllSavedTeams() = teamDao.getAllTeams()

    suspend fun deleteHero(heroEntity: HeroEntity) = heroDao.deleteHero(heroEntity)
    suspend fun deleteTeam(teamEntity: TeamEntity) = teamDao.deleteTeam(teamEntity)
}