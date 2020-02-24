package com.mmaher.box_office_kt.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mmaher.basemodule.viewModel.BaseViewModel
import com.mmaher.box_office_kt.model.Movie
import com.mmaher.box_office_kt.model.repo.MoviesRepo
import com.mmaher.box_office_kt.model.viewModel.Movies

/**
 * Created by Mina Maher (m.maher95@outlook.com) on 2020-02-21.
 */
class MoviesViewModel(application: Application) : BaseViewModel(application) {
    var moviesLiveData: MutableLiveData<Movies> = MutableLiveData()


    fun getMoviesLiveData(page: Int = 1): LiveData<Movies> {
        MoviesRepo()
            .getMovies(page)
            .doOnNext {
                moviesLiveData.postValue(it)
            }.doOnError {
                moviesLiveData.postValue(Movies(null, page, it.localizedMessage))
            }.subscribe()
        return moviesLiveData
    }
}