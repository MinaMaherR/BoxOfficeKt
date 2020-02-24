package com.mmaher.box_office_kt.model.viewModel

import com.mmaher.box_office_kt.model.Movie

/**
 * Created by Mina Maher (m.maher95@outlook.com) on 2020-02-21.
 */
data class Movies(var movies: List<Movie>?, var page: Int, var error: String?)