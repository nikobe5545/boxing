package se.beis.boxingrounds.ui.settings

import se.beis.boxingrounds.ui.base.MvpPresenter

interface SettingsMvpPresenter<V : SettingsMvpView> : MvpPresenter<V> {

    fun onSave()
}