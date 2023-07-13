package com.example.movies_list.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.movies_list.ApiClient
import com.example.movies_list.ModelClass.ResultsItem
import com.example.movies_list.databinding.MoviesItemBinding

class MovieAdapter :Adapter<MovieAdapter.MovieHolder>(){

    lateinit var movielist: List<ResultsItem?>
    lateinit var context: Context

    class MovieHolder(itemView: MoviesItemBinding) : ViewHolder(itemView.root){
        var binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {

        context = parent.context
        var binding = MoviesItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieHolder(binding)
    }

    override fun getItemCount(): Int {

        return movielist.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {

        holder.binding.apply {

            movielist.get(position)?.apply {

                Glide.with(context).load(ApiClient.IMAGE_BASED_URL+posterPath).into(imgmovie)
                txtTitle.text = originalTitle
                txtDesc.text = overview
            }
        }
    }

    fun setmovies(movielist: List<ResultsItem?>?) {
        this.movielist = movielist as List<ResultsItem?>
    }

}