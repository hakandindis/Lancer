package hakandindis.lancer.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import hakandindis.lancer.data.local.entity.HeroEntity
import kotlinx.parcelize.Parcelize


@Parcelize
data class Hero (
    @SerializedName("id"                ) var id              : Int?              = null,
    @SerializedName("name"              ) var name            : String?           = null,
    @SerializedName("localized_name"    ) var localizedName   : String?           = null,
    @SerializedName("primary_attr"      ) var primaryAttr     : String?           = null,
    @SerializedName("attack_type"       ) var attackType      : String?           = null,
    @SerializedName("roles"             ) var roles           : ArrayList<String> = arrayListOf(),
    @SerializedName("img"               ) var img             : String?           = null,
    @SerializedName("icon"              ) var icon            : String?           = null,
    @SerializedName("base_health"       ) var baseHealth      : Int?              = null,
    @SerializedName("base_health_regen" ) var baseHealthRegen : Double?           = null,
    @SerializedName("base_mana"         ) var baseMana        : Int?              = null,
    @SerializedName("base_mana_regen"   ) var baseManaRegen   : Double?           = null,
    @SerializedName("base_armor"        ) var baseArmor       : Double?           = null,
    @SerializedName("base_mr"           ) var baseMr          : Int?              = null,
    @SerializedName("base_attack_min"   ) var baseAttackMin   : Int?              = null,
    @SerializedName("base_attack_max"   ) var baseAttackMax   : Int?              = null,
    @SerializedName("base_str"          ) var baseStr         : Int?              = null,
    @SerializedName("base_agi"          ) var baseAgi         : Int?              = null,
    @SerializedName("base_int"          ) var baseInt         : Int?              = null,
    @SerializedName("str_gain"          ) var strGain         : Double?           = null,
    @SerializedName("agi_gain"          ) var agiGain         : Double?           = null,
    @SerializedName("int_gain"          ) var intGain         : Double?           = null,
    @SerializedName("attack_range"      ) var attackRange     : Int?              = null,
    @SerializedName("projectile_speed"  ) var projectileSpeed : Int?              = null,
    @SerializedName("attack_rate"       ) var attackRate      : Double?           = null,
    @SerializedName("move_speed"        ) var moveSpeed       : Int?              = null,
    @SerializedName("turn_rate"         ) var turnRate        : String?           = null,
    @SerializedName("cm_enabled"        ) var cmEnabled       : Boolean?          = null,
    @SerializedName("legs"              ) var legs            : Int?              = null,
    @SerializedName("hero_id"           ) var heroId          : Int?              = null,
    @SerializedName("turbo_picks"       ) var turboPicks      : Int?              = null,
    @SerializedName("turbo_wins"        ) var turboWins       : Int?              = null,
    @SerializedName("pro_ban"           ) var proBan          : Int?              = null,
    @SerializedName("pro_win"           ) var proWin          : Int?              = null,
    @SerializedName("pro_pick"          ) var proPick         : Int?              = null,
    @SerializedName("1_pick"            ) var Pick1           : Int?              = null,
    @SerializedName("1_win"             ) var Win1            : Int?              = null,
    @SerializedName("2_pick"            ) var Pick2           : Int?              = null,
    @SerializedName("2_win"             ) var Win2            : Int?              = null,
    @SerializedName("3_pick"            ) var Pick3           : Int?              = null,
    @SerializedName("3_win"             ) var Win3            : Int?              = null,
    @SerializedName("4_pick"            ) var Pick4           : Int?              = null,
    @SerializedName("4_win"             ) var Win4            : Int?              = null,
    @SerializedName("5_pick"            ) var Pick5           : Int?              = null,
    @SerializedName("5_win"             ) var Win5            : Int?              = null,
    @SerializedName("6_pick"            ) var Pick6           : Int?              = null,
    @SerializedName("6_win"             ) var Win6            : Int?              = null,
    @SerializedName("7_pick"            ) var Pick7           : Int?              = null,
    @SerializedName("7_win"             ) var Win7            : Int?              = null,
    @SerializedName("8_pick"            ) var Pick8           : Int?              = null,
    @SerializedName("8_win"             ) var Win8            : Int?              = null,
    @SerializedName("null_pick"         ) var nullPick        : Int?              = null,
    @SerializedName("null_win"          ) var nullWin         : Int?              = null
) : Parcelable {
    fun toEntity():HeroEntity = HeroEntity(
        id          = this.heroId,
        name        = this.localizedName,
        img         = this.img,
        primaryAttr = this.primaryAttr,
        attackType  = this.attackType,
        roles       = this.roles
    )
}
