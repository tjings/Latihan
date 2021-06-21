package umn.ac.id.paginatingapi

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private val TAG = javaClass.simpleName
    private var adapterTheMovieDb by Delegates.notNull<AdapterTMDB>()
    private var isLoading by Delegates.notNull<Boolean>()
    private var page by Delegates.notNull<Int>()
    private var totalPage by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        page = 1
        totalPage = 0
        doLoadData()
        initListener()
    }

    private fun doLoadData() {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client  =OkHttpClient.Builder().addInterceptor(logging).build()
//        Log.d(TAG, "page: $page")
        showLoading(true)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
        val apiTheMovieDb = retrofit.create(API::class.java)
        apiTheMovieDb.getNowPlaying(page = page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { theMovieDb: Model ->
                    val resultTheMovieDb = theMovieDb.results as ArrayList
                    if (page == 1) {
                        adapterTheMovieDb = AdapterTMDB(
                            this@MainActivity,
                            resultTheMovieDb
                        )
                        recycler_view_movie_activity_main.layoutManager = LinearLayoutManager(this@MainActivity)
                        recycler_view_movie_activity_main.adapter = adapterTheMovieDb
                    } else if (theMovieDb.page == theMovieDb.total_pages){
                        recycler_view_movie_activity_main.clearOnScrollListeners()
                     }else {
                        adapterTheMovieDb.refreshAdapter(resultTheMovieDb)
                    }

                    totalPage = theMovieDb.total_pages
                },
                { t: Throwable ->
                    t.printStackTrace()
                },
                {
                    hideLoading()
                }
            )
    }

    private fun initListener() {
        recycler_view_movie_activity_main.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val linearLayoutManager = recyclerView?.layoutManager as LinearLayoutManager
                val countItem = linearLayoutManager?.itemCount
                val lastVisiblePosition = linearLayoutManager?.findLastCompletelyVisibleItemPosition()
                val isLastPosition = countItem.minus(1) == lastVisiblePosition
//                Log.d(TAG, "countItem: $countItem")
//                Log.d(TAG, "lastVisiblePosition: $lastVisiblePosition")
//                Log.d(TAG, "isLastPosition: $isLastPosition")
                if (!isLoading && isLastPosition && page < totalPage) {
                    showLoading(true)
                    page = page.let { it.plus(1) }
                    doLoadData()
                }
            }
        })
    }

    private fun showLoading(isRefresh: Boolean) {
        isLoading = true
        progress_bar_horizontal_activity_main.visibility = View.VISIBLE
        recycler_view_movie_activity_main.visibility.let {
            if (isRefresh) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }

    private fun hideLoading() {
        isLoading = false
        progress_bar_horizontal_activity_main.visibility = View.GONE
        recycler_view_movie_activity_main.visibility = View.VISIBLE
    }
}