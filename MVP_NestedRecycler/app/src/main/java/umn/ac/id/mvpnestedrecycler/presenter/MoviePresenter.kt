package umn.ac.id.mvpnestedrecycler.presenter

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import umn.ac.id.mvpnestedrecycler.api.ApiClient
import umn.ac.id.mvpnestedrecycler.api.ApiInterface
import umn.ac.id.mvpnestedrecycler.model.Object

class MoviePresenter {
    private val api = ApiClient.createService(ApiInterface::class.java)

    fun getNowPlaying(
        page: Int = 1,
        onSuccess: (movies: Object) -> Unit,
        onError: () -> Unit
    ) {
        api.getNowPlaying(page = page)
            .enqueue(object : Callback<Object> {
                override fun onResponse(
                    call: Call<Object>,
                    response: Response<Object>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
//                        Log.d("nowPlaying", responseBody.toString())
                        if (responseBody != null) {
                            onSuccess.invoke(responseBody)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<Object>, t: Throwable) {
                    onError.invoke()
                    Log.e("Repository", "onFailure", t)
                }
            })
    }

    fun getNowTrending(
        onSuccess: (movies: Object) -> Unit,
        onError: () -> Unit
    ) {
        api.getNowTrending()
            .enqueue(object : Callback<Object> {
                override fun onResponse(
                    call: Call<Object>,
                    response: Response<Object>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
//                        Log.d("trendingThisWeek", responseBody!!.movies.toString())
                        if (responseBody != null) {
                            onSuccess.invoke(responseBody)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<Object>, t: Throwable) {
                    onError.invoke()
                    Log.e("Repository", "onFailure", t)
                }
            })
    }

    fun getTop(
        onSuccess: (movies: Object) -> Unit,
        onError: () -> Unit
    ) {
        api.getTop()
            .enqueue(object : Callback<Object> {
                override fun onResponse(
                    call: Call<Object>,
                    response: Response<Object>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
//                        Log.d("trendingThisWeek", responseBody!!.movies.toString())
                        if (responseBody != null) {
                            onSuccess.invoke(responseBody)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<Object>, t: Throwable) {
                    onError.invoke()
                    Log.e("Repository", "onFailure", t)
                }
            })
    }

    fun getUpcoming(
        onSuccess: (movies: Object) -> Unit,
        onError: () -> Unit
    ) {
        api.getUpcoming()
            .enqueue(object : Callback<Object> {
                override fun onResponse(
                    call: Call<Object>,
                    response: Response<Object>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
//                        Log.d("trendingThisWeek", responseBody!!.movies.toString())
                        if (responseBody != null) {
                            onSuccess.invoke(responseBody)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<Object>, t: Throwable) {
                    onError.invoke()
                    Log.e("Repository", "onFailure", t)
                }
            })
    }

}