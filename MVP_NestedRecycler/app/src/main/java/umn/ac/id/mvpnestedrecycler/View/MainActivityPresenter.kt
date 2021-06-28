package umn.ac.id.mvpnestedrecycler.View

import umn.ac.id.mvpnestedrecycler.Model.Object

interface MainActivityPresenter {
    fun onError()
    fun onFetchedNow(arrayListNow: Object)
    fun onFetchedTrending(arrayListTrending: Object)
    fun onFetchedTop(arrayListTop: Object)
    fun onFetchedUpcoming(arrayListUpcoming: Object)
}