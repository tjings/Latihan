package umn.ac.id.viewpager2

import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("v2/list?limit=3")
    fun getImage() : Call<List<Picture>>
}