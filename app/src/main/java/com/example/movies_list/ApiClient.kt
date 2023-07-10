package com.example.movies_list

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object{

        val BASED_URL = "https://api.themoviedb.org/3/movie/"
        var retrofit : Retrofit? = null

        fun getApiClient(): Retrofit? {

            if (retrofit==null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASED_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit!!
        }

    }

}