package umn.ac.id.nestedrecyclerapilagi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("movie/now_playing")
    fun getNowPlaying(
        @Query("api_key") apiKey: String = "ca3cae85bb1e478656da8986f49e7ec7",
        @Query("language") language: String = "EN-US",
        @Query("page") page: Int
    ) : Call<Model>

}