package com.example.movies_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movies_list.ModelClass.MoviesModel
import com.example.movies_list.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        callApi()


    }

    private fun callApi() {
        var api = ApiClient.getApiClient()?.create(ApiInterface::class.java)
        api?.getmovies()?.enqueue(object :Callback<MoviesModel>{
            override fun onResponse(call: Call<MoviesModel>, response: Response<MoviesModel>) {
                
            }

            override fun onFailure(call: Call<MoviesModel>, t: Throwable) {

            }

        })
    }
}