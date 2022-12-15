package hakandindis.lancer

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import hakandindis.lancer.data.database.LancerDatabase

@HiltAndroidApp
class LancerApplication : Application() {

    public val database by lazy { LancerDatabase.getDatabase(this) }
}