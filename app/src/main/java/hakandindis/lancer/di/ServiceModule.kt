package hakandindis.lancer.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hakandindis.lancer.data.remote.HeroService
import hakandindis.lancer.data.remote.TeamService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    @Singleton
    fun provideHeroService(retrofit: Retrofit): HeroService {
        return retrofit.create(HeroService::class.java)
    }

    @Provides
    @Singleton
    fun provideTeamService(retrofit: Retrofit): TeamService {
        return retrofit.create(TeamService::class.java)
    }
}