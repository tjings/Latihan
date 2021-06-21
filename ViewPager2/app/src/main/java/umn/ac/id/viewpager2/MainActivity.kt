package umn.ac.id.viewpager2

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var mPict: MutableList<Picture> = ArrayList()
    private var mApiService: APIService? = null
    private var mAdapter: Adapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mApiService = RestClient.client.create(APIService::class.java)

        mAdapter = Adapter(this, mPict)

        vp_horizontal!!.adapter = mAdapter
        fetchPict()

        vp_vertical!!.adapter = mAdapter
        fetchPict()
    }

    private fun fetchPict() {
        val call = mApiService!!.getImage()
        call.enqueue(object : Callback<List<Picture>> {
            override fun onResponse(p0: Call<List<Picture>>, p1: Response<List<Picture>>) {
                val posts = p1.body()
                if (posts != null) {
                    mPict.addAll(posts.toMutableList())
                    mAdapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(p0: Call<List<Picture>>, response: Throwable) {
                Log.e(ContentValues.TAG, "Got error : " + response.localizedMessage)

            }
        })
    }
}