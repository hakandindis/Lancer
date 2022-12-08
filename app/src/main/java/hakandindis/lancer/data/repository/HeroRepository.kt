package hakandindis.lancer.data.repository

import hakandindis.lancer.data.remote.HeroService
import javax.inject.Inject

class HeroRepository @Inject constructor(private val heroService: HeroService) {
}