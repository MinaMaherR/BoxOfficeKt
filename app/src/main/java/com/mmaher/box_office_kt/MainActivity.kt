package com.mmaher.box_office_kt

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mmaher.basemodule.view.BaseActivity
import com.mmaher.basemodule.view.adapter.BaseAdapter
import com.mmaher.box_office_kt.model.Movie
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
        adapter = BaseAdapter(movies, android.R.layout.simple_list_item_1, object: BaseAdapter.Binder<Movie>() {
            override fun bind(item: Movie, itemView: View) {
                itemView.findViewById<TextView>(android.R.id.text1).text = item.title
            }
        })

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
                this.movies.clear()
                this.movies.addAll(it.movies!!)
                adapter.notifyDataSetChanged()
                showAlert("Done 💪")

            }
        })
    }
}


