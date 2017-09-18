package se.beis.boxingrounds.ui.base

import se.beis.boxingrounds.data.DataManager

open class BasePresenter<V : MvpView>(dataManager: DataManager) : MvpPresenter<V> {

    var dataManager: DataManager
        internal set
    var mvpView: V? = null
        private set


    init {
        this.dataManager = dataManager
    }

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
    }
}
