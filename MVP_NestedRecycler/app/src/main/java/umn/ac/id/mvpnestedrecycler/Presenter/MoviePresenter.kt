package umn.ac.id.mvpnestedrecycler.Presenter

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import umn.ac.id.mvpnestedrecycler.Api.ApiClient
import umn.ac.id.mvpnestedrecycler.Api.ApiInterface
import umn.ac.id.mvpnestedrecycler.Model.Model

class MoviePresenter : iMoviePresenter {
    private val api = ApiClient.createService(ApiInterface::class.java)
    override fun getNowPlaying(
        page: Int,
        onSuccess: (movies : Model) -> Unit,
        onError: () -> Unit
    ) {
        api.getNowPlaying(page = page)
            .enqueue(object : Callback<Model> {
                override fun onResponse(
                    call: Call<Model>,
                    response: Response<Model>
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

                override fun onFailure(call: Call<Model>, t: Throwable) {
                    onError.invoke()
                    Log.e("Repository", "onFailure", t)
                }
            })
    }

    override fun getNowTrending(
        page: Int,
        onSuccess: (movies : Model) -> Unit,
        onError: () -> Unit
    ) {
        api.getNowTrending()
            .enqueue(object : Callback<Model> {
                override fun onResponse(
                    call: Call<Model>,
                    response: Response<Model>
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

                override fun onFailure(call: Call<Model>, t: Throwable) {
                    onError.invoke()
                    Log.e("Repository", "onFailure", t)
                }
            })
    }

}