package umn.ac.id.firstretrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {

    private var mRetrofit: Retrofit? = null

    val client: Retrofit
        get() {
            if(mRetrofit == null) {
                mRetrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                            .baseUrl("https://jsonplaceholder.typicode.com/").build()
            }
        return this.mRetrofit!!
        }
}