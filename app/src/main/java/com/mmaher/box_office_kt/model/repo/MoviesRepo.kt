package com.mmaher.box_office_kt.model.repo

import com.mmaher.basemodule.model.repo.APIClient
import com.mmaher.box_office_kt.model.viewModel.Movies
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Mina Maher (m.maher95@outlook.com) on 2020-02-21.
 */
class MoviesRepo {
    fun getMovies (page: Int = 1): Observable<Movies> {
        return APIClient.shared.retrofit.create(MoviesService::class.java)
            .getMovies(page)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.single())
            .map { Movies(it.results, it.page, null) }
    }
}