package umn.ac.id.imageapi

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var mPict: MutableList<Picture> = ArrayList()
    private var mApiService: APIService? = null
    private var mAdapter: Adapter?= null
    private var mRecyclerView : RecyclerView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mApiService = RestClient.client.create(APIService::class.java)

        mRecyclerView = findViewById(R.id.listRecyclerView)
        mRecyclerView!!.layoutManager = LinearLayoutManager(this)

        mAdapter = Adapter(this, mPict)
        mRecyclerView?.adapter = mAdapter

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