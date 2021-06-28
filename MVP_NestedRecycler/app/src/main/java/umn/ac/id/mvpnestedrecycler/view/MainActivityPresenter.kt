package umn.ac.id.mvpnestedrecycler.view

import umn.ac.id.mvpnestedrecycler.model.Object

interface MainActivityPresenter {
    fun onError()
    fun onFetchedNow(arrayListNow: Object)
    fun onFetchedTrending(arrayListTrending: Object)
    fun onFetchedTop(arrayListTop: Object)
    fun onFetchedUpcoming(arrayListUpcoming: Object)
}