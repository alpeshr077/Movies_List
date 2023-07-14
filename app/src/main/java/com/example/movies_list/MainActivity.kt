package com.example.movies_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.movies_list.Adapter.MovieAdapter
import com.example.movies_list.ModelClass.ResultsItem
import com.example.movies_list.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var page = 1
    lateinit var binding: ActivityMainBinding
    var adapter = MovieAdapter()
    var list = ArrayList<ResultsItem>()

    var item = arrayOf("Playing", "Popular", "Top Rate", "Upcoming")
    var fragments =
        arrayOf(Playing_fragment(), Popular_Fragment(), Top_Rate_Fragment(), Upcoming_Fragment())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = FragmentAdapter(supportFragmentManager, fragments, item)
        binding.TabLayout.setupWithViewPager(binding.viewPager)

    }
}