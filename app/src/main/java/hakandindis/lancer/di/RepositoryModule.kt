package hakandindis.lancer.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hakandindis.lancer.data.remote.HeroService
import hakandindis.lancer.data.repository.HeroRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCharacterRepository(heroService: HeroService): HeroRepository {
        return HeroRepository(heroService)
    }
}