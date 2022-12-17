package hakandindis.lancer.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hakandindis.lancer.data.local.dao.HeroDao
import hakandindis.lancer.data.local.dao.TeamDao
import hakandindis.lancer.data.local.entity.HeroEntity

@Database(
    entities = [HeroEntity::class],
    version = 1,
    exportSchema = true,
//    autoMigrations = [AutoMigration(from = 1, to = 2)]
)
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