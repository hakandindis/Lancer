package hakandindis.lancer.data.repository

import hakandindis.lancer.data.local.dao.HeroDao
import hakandindis.lancer.data.local.dao.TeamDao
import javax.inject.Inject

class SavedRepository @Inject constructor(
    private val heroDao: HeroDao,
    private val teamDao: TeamDao
) {
}