package com.example.movies_list

import com.example.movies_list.ModelClass.MoviesModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface_3 {

    @GET("top_rated")

    fun getTopRatemovies(
        @Query("page")page:Int
    ): Call<MoviesModel>

}