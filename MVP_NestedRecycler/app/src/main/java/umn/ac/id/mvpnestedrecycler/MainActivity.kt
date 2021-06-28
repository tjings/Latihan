package umn.ac.id.mvpnestedrecycler

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import umn.ac.id.mvpnestedrecycler.Adapter.HomeAdapter
import umn.ac.id.mvpnestedrecycler.Model.Object
import umn.ac.id.mvpnestedrecycler.Presenter.MoviePresenter
import umn.ac.id.mvpnestedrecycler.View.MainActivityPresenter

class MainActivity : AppCompatActivity(), MainActivityPresenter {
    private var movs: ArrayList<Object> = arrayListOf()
    private lateinit var moviePresenter: MoviePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moviePresenter = MoviePresenter()
        movs.add(Object("Now Playing", null))
        movs.add(Object("Trending", null))
        movs.add(Object("Top", null))
        movs.add(Object("Upcoming", null))

        rv_main.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_main.adapter = HomeAdapter(movs)

        moviePresenter.getNowTrending(
            onSuccess = ::onFetchedTrending,
            onError = ::onError
        )
        moviePresenter.getTop(
            onSuccess = ::onFetchedTop,
            onError = ::onError
        )
        moviePresenter.getUpcoming(
            onSuccess = ::onFetchedUpcoming,
            onError = ::onError
        )
        moviePresenter.getNowPlaying(
            onSuccess = ::onFetchedNow,
            onError = ::onError
        )
    }

    override fun onError() {
        Toast.makeText(this, "Error Fetching", Toast.LENGTH_SHORT).show()
        pb_main.visibility = View.GONE
    }

    override fun onFetchedNow(arrayListNow: Object) {
        val movie = movs.firstOrNull {
            it.category == "Now Playing"
        }
        movie?.let {
            if (it.movies == null) {
                it.movies = arrayListOf()
            }
            it.movies!!.addAll(arrayListNow.movies!!.toMutableList())
            rv_main.adapter?.notifyDataSetChanged()
        }
    }

    override fun onFetchedTop(arrayListTop: Object) {
        pb_main.visibility = View.GONE
        val movie = movs.firstOrNull {
            it.category == "Top"
        }
        movie?.let {
            if (it.movies == null) {
                it.movies = arrayListOf()
            }
            it.movies!!.addAll(arrayListTop.movies!!.toMutableList())
            rv_main.adapter?.notifyDataSetChanged()
        }
    }

    override fun onFetchedUpcoming(arrayListUpcoming: Object) {
        pb_main.visibility = View.GONE
        val movie = movs.firstOrNull {
            it.category == "Upcoming"
        }
        movie?.let {
            if (it.movies == null) {
                it.movies = arrayListOf()
            }
            it.movies!!.addAll(arrayListUpcoming.movies!!.toMutableList())
            rv_main.adapter?.notifyDataSetChanged()
        }
    }

    override fun onFetchedTrending(arrayListTrending: Object) {
        pb_main.visibility = View.GONE

        val movie = movs.firstOrNull {
            it.category == "Trending"
        }
        movie?.let {
            if (it.movies == null) {
                it.movies = arrayListOf()
            }
            it.movies!!.addAll(arrayListTrending.movies!!.toMutableList())
            rv_main.adapter?.notifyDataSetChanged()
        }
    }
}
