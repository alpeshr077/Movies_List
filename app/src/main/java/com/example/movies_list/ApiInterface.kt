package com.example.movies_list

import com.example.movies_list.ModelClass.MoviesModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiInterface {

    @GET("upcoming")

    fun getUpcomingmovies(
        @Query("page")page:Int
    ):Call<MoviesModel>

}