package umn.ac.id.nestedrecyclerapilagi

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var movs: ArrayList<Model> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitObject.getNowPlaying(
            onSuccess = ::onFetchedNow,
            onError = ::onError
        )

        RetrofitObject.getTrendingThisWeek(
            onSuccess = ::onFetchedTrending,
            onError = ::onError
        )
    }

    private fun onFetchedNow(arrayListNow: Model) {
        var item = Model("Now Playing", arrayListNow.movies)
        movs.add(item)
        rv_main.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        Log.d("123123", movs.toString())
        rv_main.adapter = HomeAdapter(movs)
        pb_main.setVisibility(View.GONE)
    }

    private fun onFetchedTrending(arrayListTrending: Model) {
        var item = Model("Trending This Week", arrayListTrending.movies)
        movs.add(item)
        rv_main.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        Log.d("123123", movs.toString())
        rv_main.adapter = HomeAdapter(movs)
        pb_main.setVisibility(View.GONE)
    }

    private fun onError() {
        Toast.makeText(this, "Error Fetching", Toast.LENGTH_SHORT).show()
        pb_main.setVisibility(View.GONE);
    }
}