package umn.ac.id.imageapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {

    private var mRetrofit: Retrofit? = null

    val client: Retrofit
        get() {
            if(mRetrofit == null) {
                mRetrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://picsum.photos//").build()
            }
            return this.mRetrofit!!
        }
}