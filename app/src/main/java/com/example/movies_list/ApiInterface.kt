package com.example.movies_list

import com.example.movies_list.ModelClass.MoviesModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("upcoming")

    fun getmovies():Call<MoviesModel>

}