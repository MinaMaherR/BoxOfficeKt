package com.mmaher.box_office_kt.view.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mmaher.basemodule.view.adapter.BaseAdapter
import com.mmaher.box_office_kt.R
import com.mmaher.box_office_kt.helpers.MovieHelper
import com.mmaher.box_office_kt.model.Movie
import com.mmaher.box_office_kt.model.repo.BoxOfficeAPIConstants

/**
 * Created by Mina Maher (m.maher95@outlook.com) on 2020-02-28.
 */
class MoviesAdapter(items: List<Movie>,
                    layoutId: Int
) : BaseAdapter<Movie>(items, layoutId, object: Binder<Movie>() {
    override fun bind(
        item: Movie,
        itemViewType: Int,
        itemView: View
    ) {
        itemView.findViewById<TextView>(R.id.titleTV).text = item.title
        itemView.findViewById<TextView>(R.id.overview).text = item.overview
        itemView.findViewById<TextView>(R.id.releaseDateTV).text = MovieHelper.getFormattedDateForMovie(item)

        val image = itemView.findViewById<ImageView>(R.id.imageIV)
        // Rest image for reusing items
        val context = itemView.context
        image.setImageDrawable(MovieHelper.getMoviePlaceholder(context))
        val imageUri = MovieHelper.getImageURIForMovie(item, BoxOfficeAPIConstants.ImageSizes.ORIGINAL)
        Glide.with(context)
            .load(imageUri)
            .centerCrop()
            .placeholder(MovieHelper.getMoviePlaceholder(context))
            .into(image)
    }
})