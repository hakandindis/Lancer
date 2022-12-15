package hakandindis.lancer.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hakandindis.lancer.data.database.LancerDatabase
import hakandindis.lancer.data.local.dao.HeroDao
import hakandindis.lancer.data.local.dao.TeamDao
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DaoModule {

    private val DATABASENAME = "lancer_database"

    @Provides
    @Singleton
    fun provideLancerDatabase(@ApplicationContext context: Context): LancerDatabase {
        return Room.databaseBuilder(
            context,
            LancerDatabase::class.java,
            DATABASENAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideHeroDao(database: LancerDatabase): HeroDao {
        return database.heroDao()
    }

    @Provides
    @Singleton
    fun provideTeamDao(database: LancerDatabase): TeamDao {
        return database.teamDao()
    }
}