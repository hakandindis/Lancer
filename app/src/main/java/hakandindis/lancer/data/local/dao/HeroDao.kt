package hakandindis.lancer.data.local.dao

import androidx.room.*
import hakandindis.lancer.data.local.entity.HeroEntity

@Dao
interface HeroDao {

    @Insert
    suspend fun insertHero(heroEntity: HeroEntity)

    @Update
    suspend fun updateHero(heroEntity: HeroEntity)

    @Delete
    suspend fun deleteHero(heroEntity: HeroEntity)

    @Query("SELECT * FROM heroes")
    suspend fun getAllHeroes(): List<HeroEntity>
}