package com.example.mainactivity.movie

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mainactivity.R
import java.util.*
import kotlin.collections.ArrayList

class TopRateFragment : Fragment(), OnDataToFragmentListener {
    var movies: ArrayList<Movie> = ArrayList()
    lateinit var movieAdapter: MovieAdapter

    override fun sendDataToFragment(movies: ArrayList<Movie>) {
        this.movies = movies
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_top_rate, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_top_rate)

        recyclerView.layoutManager = LinearLayoutManager(activity) as RecyclerView.LayoutManager?
        movieAdapter = MovieAdapter(movies, activity as Context)
        recyclerView.adapter = movieAdapter
        movieAdapter.setListener(movieItemClickListener)

        return view
    }

    private val movieItemClickListener = object : MovieItemClickListener {
        override fun onItemCLicked(position: Int) {
            val intent = Intent(activity, DetailsActivity::class.java)
            val item = movies[position]
            intent.putExtra(
                MOVIE_MODEL_KEY,
                MovieModel(item.title, item.image_url, item.source_url, item.ingredients, item.f2f_url)
            )
            startActivity(intent)
        }

        override fun onItemLongCLicked(position: Int) {
            // Dialog
        }
    }

    private fun randomInRange(min: Int, max: Int): Int {
        // Define a new Random class
        val r = Random()

        // Get the next random number within range
        // Including both minimum and maximum number
        return r.nextInt((max - min) + 1) + min;
    }
}