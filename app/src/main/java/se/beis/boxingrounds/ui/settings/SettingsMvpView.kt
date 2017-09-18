package se.beis.boxingrounds.ui.settings

import se.beis.boxingrounds.ui.base.MvpView

interface SettingsMvpView : MvpView {

    fun openMainActivity()

    fun saveSettings()
}