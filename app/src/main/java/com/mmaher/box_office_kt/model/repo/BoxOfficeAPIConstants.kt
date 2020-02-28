package com.mmaher.box_office_kt.model.repo

import com.mmaher.basemodule.model.repo.APIConstants

/**
 * Created by Mina Maher (m.maher95@outlook.com) on 2020-02-28.
 */
interface BoxOfficeAPIConstants: APIConstants {
    companion object {
        val imageBaseURL: String = "https://image.tmdb.org//t//p"
    }

    enum class ImageSizes(val size: String) {
        ORIGINAL("original"),
        W500("w500")
    }
}