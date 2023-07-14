package com.example.movies_list

import com.example.movies_list.ModelClass.MoviesModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface_2 {

    @GET("popular")

    fun getPopularmovies(
        @Query("page")page:Int
    ): Call<MoviesModel>

}