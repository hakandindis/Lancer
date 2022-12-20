package hakandindis.lancer.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import hakandindis.lancer.data.model.Team

@Entity(tableName = "teams")
data class TeamEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var teamId: Int? = null,
    @ColumnInfo(name = "name") var name: String? = null,
    @ColumnInfo(name = "rating") var rating: Double? = null,
    @ColumnInfo(name = "wins") var wins: Int? = null,
    @ColumnInfo(name = "losses") var losses: Int? = null,
    @ColumnInfo(name = "last_match_time") var lastMatchTime: Int? = null,
    @ColumnInfo(name = "tag") var tag: String? = null,
    @ColumnInfo(name = "logo_url") var logoUrl: String? = null
) {
    fun toModel() = Team(
        teamId = this.teamId,
        name = this.name,
        rating = this.rating,
        wins = this.wins,
        losses = this.losses,
        lastMatchTime = this.lastMatchTime,
        tag = this.tag,
        logoUrl = this.logoUrl
    )
}