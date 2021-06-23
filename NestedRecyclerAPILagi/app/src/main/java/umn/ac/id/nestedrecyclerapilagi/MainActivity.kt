package umn.ac.id.nestedrecyclerapilagi

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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
        pb_main.setVisibility(View.GONE);
    }

    private fun onFetched(arrayList: ArrayList<ModelKecil>) {
        rv_main.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_main.adapter = HomeAdapter(arrayList)
        pb_main.setVisibility(View.GONE);
    }
}