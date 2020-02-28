package com.mmaher.box_office_kt.helpers

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import androidx.core.content.ContextCompat
import com.mmaher.box_office_kt.R
import com.mmaher.box_office_kt.model.Movie
import com.mmaher.box_office_kt.model.repo.BoxOfficeAPIConstants
import java.text.SimpleDateFormat

/**
 * Created by Mina Maher (m.maher95@outlook.com) on 2020-02-28.
 */
class MovieHelper {
    companion object {
        val TAG = "===${javaClass.simpleName}==="

        fun getImageURIForMovie(movie: Movie, size: BoxOfficeAPIConstants.ImageSizes): Uri {
            val uri = Uri.parse(BoxOfficeAPIConstants.imageBaseURL)
                .buildUpon()
                .appendPath(size.size)
                .appendEncodedPath(movie.poster_path)
                .build()
            Log.d(TAG, uri.toString())
            return uri
        }

        fun getFormattedDateForMovie(movie: Movie, format: String = "dd/MM/yyyy"): String? {
            val formatter = SimpleDateFormat(format)
            return formatter.format(movie.release_date)
        }

        fun getMoviePlaceholder(context: Context): Drawable? {
            return ContextCompat.getDrawable(context, R.drawable.placeholder_image)
        }
    }
}