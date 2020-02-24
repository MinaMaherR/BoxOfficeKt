package com.mmaher.box_office_kt.model.api

import com.mmaher.box_office_kt.model.Movie

/**
 * Created by Mina Maher (m.maher95@outlook.com) on 2020-02-21.
 */
data class MoviesResponse(var page: Int, var results: List<Movie>)