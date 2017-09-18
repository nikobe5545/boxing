package se.beis.boxingrounds

import android.app.Application
import se.beis.boxingrounds.data.DataManager
import se.beis.boxingrounds.data.SharedPrefsHelper

class MvpApp : Application() {

    lateinit var dataManager: DataManager
        internal set

    override fun onCreate() {
        super.onCreate()

        val sharedPrefsHelper = SharedPrefsHelper(applicationContext)
        dataManager = DataManager(sharedPrefsHelper)

    }

}