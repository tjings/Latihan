package umn.ac.id.mvpnestedrecycler.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import umn.ac.id.mvpnestedrecycler.model.Object

interface ApiInterface {
    @GET("movie/now_playing")
    fun getNowPlaying(
        @Query("api_key") apiKey: String = "ca3cae85bb1e478656da8986f49e7ec7",
        @Query("language") language: String = "EN-US",
        @Query("page") page: Int
    ) : Call<Object>

    @GET("trending/movie/week")
    fun getNowTrending(
        @Query("api_key") apiKey: String = "ca3cae85bb1e478656da8986f49e7ec7",
    ) : Call<Object>

    @GET ("movie/top_rated")
    fun getTop(
        @Query("api_key") apiKey: String = "ca3cae85bb1e478656da8986f49e7ec7"
    ) : Call<Object>

    @GET ("movie/upcoming")
    fun getUpcoming(
        @Query("api_key") apiKey: String = "ca3cae85bb1e478656da8986f49e7ec7"
    ) : Call<Object>
}