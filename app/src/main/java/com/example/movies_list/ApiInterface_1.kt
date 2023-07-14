package com.example.movies_list

import com.example.movies_list.ModelClass.MoviesModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface_1 {

    @GET("now_playing")

    fun getPlayingmovies(
        @Query("page")page:Int
    ): Call<MoviesModel>

}