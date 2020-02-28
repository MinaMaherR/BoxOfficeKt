package com.mmaher.box_office_kt.view.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mmaher.basemodule.view.BaseActivity
import com.mmaher.basemodule.view.adapter.BaseAdapter
import com.mmaher.box_office_kt.R
import com.mmaher.box_office_kt.model.Movie
import com.mmaher.box_office_kt.view.adapter.MoviesAdapter
import com.mmaher.box_office_kt.viewModel.MoviesViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity: BaseActivity<MoviesViewModel>() {
    lateinit var adapter: BaseAdapter<Movie>
    var movies: ArrayList<Movie> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initObservers()
    }

    private fun initViews() {
        adapter = MoviesAdapter(movies, R.layout.item_movie)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun initObservers() {
        showLoadingView()
        viewModel.getMoviesLiveData().observe(this, Observer {
            hideLoadingView()
            if (it.error != null) {
                showAlert(it.error!!)
            } else if (it.movies != null) {
                updateMovies(it.movies!!)
                showAlert("Done 💪")
            }
        })
    }

    private fun updateMovies(newMovies: List<Movie>) {
        movies.clear()
        movies.addAll(newMovies)
        adapter.notifyDataSetChanged()
    }
}


