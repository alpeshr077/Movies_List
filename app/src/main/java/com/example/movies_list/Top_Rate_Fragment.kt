package com.example.movies_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies_list.Adapter.MovieAdapter
import com.example.movies_list.ModelClass.MoviesModel
import com.example.movies_list.ModelClass.ResultsItem
import com.example.movies_list.databinding.FragmentPlayingFragmentBinding
import com.example.movies_list.databinding.FragmentTopRateBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Top_Rate_Fragment : Fragment() {

    var page = 1
    lateinit var binding: FragmentTopRateBinding
    var adapter = MovieAdapter()
    var list = ArrayList<ResultsItem>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTopRateBinding.inflate(layoutInflater)

        binding.nested.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {

                page++
                callApi(page)
            }
        })

        callApi(page)

        return binding.root
    }

    private fun callApi(page: Int) {
        var api = ApiClient.getApiClient()?.create(ApiInterface_3::class.java)
        api?.getTopRatemovies(page)?.enqueue(object : Callback<MoviesModel> {
            override fun onResponse(call: Call<MoviesModel>, response: Response<MoviesModel>) {

                if (response.isSuccessful) {
                    var movielist = response.body()?.results

                    list.addAll(movielist as ArrayList<ResultsItem>)

                    adapter.setmovies(list)
                    binding.rcvMovies.layoutManager = LinearLayoutManager(context)
                    binding.rcvMovies.adapter = adapter
                }

            }

            override fun onFailure(call: Call<MoviesModel>, t: Throwable) {

            }

        })
    }

}