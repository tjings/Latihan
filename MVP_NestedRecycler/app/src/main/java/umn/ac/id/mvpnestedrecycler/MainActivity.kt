package umn.ac.id.mvpnestedrecycler

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import umn.ac.id.mvpnestedrecycler.Adapter.HomeAdapter
import umn.ac.id.mvpnestedrecycler.Model.Model
import umn.ac.id.mvpnestedrecycler.Presenter.MoviePresenter
import umn.ac.id.mvpnestedrecycler.View.iMainActivity

class MainActivity : AppCompatActivity(), iMainActivity {
    var movs: ArrayList<Model> = arrayListOf()
    internal lateinit var moviePresenter: MoviePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moviePresenter = MoviePresenter()

        moviePresenter.getNowTrending(
            onSuccess = ::onFetchedTrending,
            onError = ::onError
        )

    }

    override fun onError() {
        Toast.makeText(this, "Error Fetching", Toast.LENGTH_SHORT).show()
        pb_main.setVisibility(View.GONE);
    }

    override fun onFetchedNow(arrayListNow: Model) {
        var item = Model("Now Playing", arrayListNow.movies)
        movs.add(item)
        rv_main.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_main.adapter = HomeAdapter(movs)
        pb_main.setVisibility(View.GONE)


        moviePresenter.getTop(
            onSuccess = ::onFetchedTop,
            onError = ::onError
        )
    }

    override fun onFetchedTop(arrayListTop: Model) {
        var item = Model("Top Ratings", arrayListTop.movies)
        movs.add(item)
        rv_main.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_main.adapter = HomeAdapter(movs)
        pb_main.setVisibility(View.GONE)

        moviePresenter.getUpcoming(
            onSuccess = ::onFetchedUpcoming,
            onError = ::onError
        )
    }

    override fun onFetchedUpcoming(arrayListUpcoming: Model) {
        var item = Model("Upcoming", arrayListUpcoming.movies)
        movs.add(item)
        rv_main.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_main.adapter = HomeAdapter(movs)
        pb_main.setVisibility(View.GONE)
    }

    override fun onFetchedTrending(arrayListTrending: Model) {
        var item = Model("Trending This Week", arrayListTrending.movies)
        movs.add(item)
        rv_main.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_main.adapter = HomeAdapter(movs)
        pb_main.setVisibility(View.GONE)

        moviePresenter.getNowPlaying(
            page = 1,
            onSuccess = ::onFetchedNow,
            onError = ::onError
        )
    }
}