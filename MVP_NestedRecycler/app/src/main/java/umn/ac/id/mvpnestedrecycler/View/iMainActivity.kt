package umn.ac.id.mvpnestedrecycler.View

import umn.ac.id.mvpnestedrecycler.Model.Model

interface iMainActivity {
    fun onError()
    fun onFetchedNow(arrayListNow: Model)
    fun onFetchedTrending(arrayListTrending: Model)
    fun onFetchedTop(arrayListTop: Model)
    fun onFetchedUpcoming(arrayListUpcoming: Model)
}