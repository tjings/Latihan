package umn.ac.id.nestedrecyclerapilagi

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    private val api : ApiClient

    init {
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(ApiClient::class.java)
    }

    fun getNowPlaying(
        page: Int = 1,
        onSuccess : (movies: ArrayList<ModelKecil>) -> Unit,
        onError : () -> Unit
    ) {
        api.getNowPlaying(page = page)
            .enqueue(object : Callback<Model> {
                override fun onResponse(
                    call: Call<Model>,
                    response: Response<Model>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        Log.d ("responseBodt", responseBody!!.movies.toString())
                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.movies)
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