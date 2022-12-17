package hakandindis.lancer.data.database

import android.content.Context
import androidx.room.*
import hakandindis.lancer.data.local.dao.HeroDao
import hakandindis.lancer.data.local.dao.TeamDao
import hakandindis.lancer.data.local.entity.HeroEntity
import hakandindis.lancer.data.local.entity.TeamEntity

@Database(
    entities = [HeroEntity::class, TeamEntity::class],
    version = 1,
//    autoMigrations = [AutoMigration(from = 2, to = 3)]
)
@TypeConverters(HeroTypeConverters::class)
abstract class LancerDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao

    abstract fun teamDao(): TeamDao

    companion object {

        val DATABASENAME = "lancer_database"

        @Volatile
        private var INSTANCE: LancerDatabase? = null

        fun getDatabase(context: Context): LancerDatabase {
            return INSTANCE ?: synchronized(this) {
                return Room.databaseBuilder(
                    context.applicationContext,
                    LancerDatabase::class.java,
                    DATABASENAME
                ).build()
            }
        }
    }
}