package com.example.movies_list

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object{

        val BASED_URL = "https://api.themoviedb.org/3/movie/"
        val IMAGE_BASED_URL = "https://image.tmdb.org/t/p/w500"

        var TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyZDY1ZDI3ODNlYzdhMmUyNzY0MDNjNDJjNWMwZWM3MSIsInN1YiI6IjY0YWFhODM1YjY4NmI5MDE1MDEwMTBhYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.NQVwz87XsbFDFU7y8QkC3Tf12d7orprZkoo_5TiGZYs"
        var retrofit : Retrofit? = null

        fun getApiClient(): Retrofit? {

            if (retrofit==null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASED_URL)
                    .addConverterFactory(GsonConverterFactory.create())

                    .client(OkHttpClient.Builder().addInterceptor { chain ->
                        val request = chain.request().newBuilder().addHeader("Authorization","Bearer ${TOKEN}").build()
                        chain.proceed(request)
                    }.build())
                    .build()
            }
            return retrofit!!
        }

    }

}