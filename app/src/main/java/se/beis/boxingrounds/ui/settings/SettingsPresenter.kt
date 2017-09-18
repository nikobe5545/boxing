package se.beis.boxingrounds.ui.settings

import se.beis.boxingrounds.data.DataManager
import se.beis.boxingrounds.ui.base.BasePresenter

class SettingsPresenter<V : SettingsMvpView>(dataManager: DataManager) :
        BasePresenter<V>(dataManager), SettingsMvpPresenter<V> {

    override fun onSave() {
        dataManager.mSharedPrefsHelper.putNumberOfRounds(2)
        dataManager.mSharedPrefsHelper.putBreakTime(60)
        dataManager.mSharedPrefsHelper.putPrepTime(10)
        dataManager.mSharedPrefsHelper.putRoundTime(180)
    }
}