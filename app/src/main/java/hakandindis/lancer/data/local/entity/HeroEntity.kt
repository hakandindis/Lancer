package hakandindis.lancer.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import hakandindis.lancer.data.database.HeroTypeConverters

@Entity(tableName = "heroes")
data class HeroEntity(
    @PrimaryKey(autoGenerate = true)           val id          : Int?               = null,
    @ColumnInfo(name = "name")                 val name        : String?            = null,
    @ColumnInfo(name = "img")                  val img         : String?            = null,
    @ColumnInfo(name = "primary_attr")         val primaryAttr : String?            = null,
    @ColumnInfo(name = "attack_type")          val attackType  : String?            = null,
    @ColumnInfo(name = "roles")
    @TypeConverters(HeroTypeConverters::class) val roles       : ArrayList<String>? = null
)