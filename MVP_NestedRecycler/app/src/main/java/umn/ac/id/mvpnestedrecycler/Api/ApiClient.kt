package umn.ac.id.mvpnestedrecycler.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        private val retrofit = Retrofit
            .Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())

        fun <S> createService(serviceClass: Class<S>): S {
            val retrofit = retrofit.build()
            return retrofit.create(serviceClass)
        }
    }
}