package umn.ac.id.imageapi

import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("v2/list?limit=10")
    fun getImage() : Call<List<Picture>>
}