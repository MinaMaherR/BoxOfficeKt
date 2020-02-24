package com.mmaher.box_office_kt.model.repo

import com.mmaher.box_office_kt.model.api.MoviesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Mina Maher (m.maher95@outlook.com) on 2020-02-21.
 */
interface MoviesService {
    @GET("discover/movie")
    fun getMovies(@Query("page") page: Int): Observable<MoviesResponse>
}