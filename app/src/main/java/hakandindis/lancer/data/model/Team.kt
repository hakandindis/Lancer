package hakandindis.lancer.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import hakandindis.lancer.data.local.entity.TeamEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team (
    @SerializedName("team_id"         ) var teamId        : Int?    = null,
    @SerializedName("rating"          ) var rating        : Double? = null,
    @SerializedName("wins"            ) var wins          : Int?    = null,
    @SerializedName("losses"          ) var losses        : Int?    = null,
    @SerializedName("last_match_time" ) var lastMatchTime : Int?    = null,
    @SerializedName("name"            ) var name          : String? = null,
    @SerializedName("tag"             ) var tag           : String? = null,
    @SerializedName("logo_url"        ) var logoUrl       : String? = null
): Parcelable {
    fun toEntity(): TeamEntity = TeamEntity(
        teamId        = this.teamId,
        name          = this.name,
        rating        = this.rating,
        wins          = this.wins,
        losses        = this.losses,
        lastMatchTime = this.lastMatchTime,
        tag           = this.tag,
        logoUrl       = this.logoUrl
    )
}