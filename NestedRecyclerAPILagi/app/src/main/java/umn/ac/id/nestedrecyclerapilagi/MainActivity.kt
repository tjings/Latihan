package umn.ac.id.nestedrecyclerapilagi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var popularMoviesAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitObject.getNowPlaying(
            onSuccess = ::onFetched,
            onError = ::onError
        )
    }

    private fun onError() {
        Toast.makeText(this, "Error Fetching", Toast.LENGTH_SHORT).show()
    }

    private fun onFetched(arrayList: ArrayList<Model>) {
        rv_main.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_main.adapter = HomeAdapter(this, arrayList)

//        Log.d("MainActivity", "Movies: $arrayList")
    }

}