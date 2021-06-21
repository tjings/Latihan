package umn.ac.id.firstretrofit

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var mApiService: PostServices? = null

    private var mAdapter: Adapter?= null
    private var mPosts: MutableList<PostModel> = ArrayList()
    private var mRecyclerView : RecyclerView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mApiService = Client.client.create(PostServices::class.java)

        mRecyclerView = findViewById(R.id.listRecyclerView)
        mRecyclerView!!.layoutManager = LinearLayoutManager(this)

        mAdapter = Adapter(this, mPosts)
        mRecyclerView!!.adapter = mAdapter

        fetchPosts()
    }

    private fun fetchPosts() {
        val call = mApiService!!.getPost()
        call.enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(p0: Call<List<PostModel>>, p1: Response<List<PostModel>>) {
                val posts = p1.body()
                if (posts != null) {
                    mPosts.addAll(posts.toMutableList())
                    mAdapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(p0: Call<List<PostModel>>, response: Throwable) {
                Log.e(TAG, "Got error : " + response.localizedMessage)

            }
        })
    }
}
