package hakandindis.lancer.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hakandindis.lancer.data.remote.HeroService
import hakandindis.lancer.data.remote.TeamService
import hakandindis.lancer.data.repository.HeroRepository
import hakandindis.lancer.data.repository.TeamRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCharacterRepository(heroService: HeroService): HeroRepository {
        return HeroRepository(heroService)
    }

    @Provides
    @Singleton
    fun provideTeamRepository(teamService: TeamService): TeamRepository {
        return TeamRepository(teamService)
    }
}