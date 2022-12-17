package hakandindis.lancer.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import hakandindis.lancer.data.local.entity.TeamEntity

@Dao
interface TeamDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(teamEntity: TeamEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTeam(teamEntity: TeamEntity)

    @Delete
    suspend fun deleteTeam(teamEntity: TeamEntity)

    @Query("SELECT * FROM teams")
    fun getAllTeams(): LiveData<List<TeamEntity>>
}