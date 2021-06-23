package umn.ac.id.mvpnestedrecycler.Presenter

import umn.ac.id.mvpnestedrecycler.Model.Model

interface iMoviePresenter {
    fun getNowPlaying(page: Int = 1,
                      onSuccess : (movies: Model) -> Unit,
                      onError : () -> Unit)
    fun getNowTrending(page: Int = 1,
                       onSuccess : (movies: Model) -> Unit,
                       onError : () -> Unit)
}