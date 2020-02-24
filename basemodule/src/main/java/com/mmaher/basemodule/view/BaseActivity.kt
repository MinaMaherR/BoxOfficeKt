package com.mmaher.basemodule.view

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import java.lang.reflect.ParameterizedType


/**
 * Created by Mina Maher (m.maher95@outlook.com) on 2020-02-21.
 */
open class BaseActivity<ViewModelType: ViewModel>: AppCompatActivity() {
    lateinit var viewModel: ViewModelType
    protected lateinit var rootView: ViewGroup
    protected lateinit var progressBarLayout: RelativeLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootView = findViewById(android.R.id.content)
        initProgressBar()
        viewModel = getViewModelForThisClass()

    }

    @Suppress("UNCHECKED_CAST")
    private fun getViewModelClassType (): Class<ViewModelType> {
        return (javaClass
            .genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<ViewModelType>
    }

    private fun getViewModelForThisClass(): ViewModelType {
        return ViewModelProvider(this).get(getViewModelClassType())
    }


    private fun initProgressBar () {
        progressBarLayout = RelativeLayout(this)
        val progressBar = ProgressBar(this, null, android.R.attr.progressBarStyleLarge)
        progressBar.isIndeterminate = true
        progressBar.visibility = View.VISIBLE
        val params = RelativeLayout.LayoutParams(100, 100)
        progressBarLayout.addView(progressBar, params)
        params.addRule(RelativeLayout.CENTER_IN_PARENT)
    }

    protected fun showLoadingView () {
        val layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        rootView.addView(progressBarLayout, layoutParams)
    }

    protected fun hideLoadingView () {
        rootView.removeView(progressBarLayout)
    }

    protected fun showAlert (error: String) {
        findViewById<View>(android.R.id.content)
        Snackbar.make(rootView, error, Snackbar.LENGTH_LONG).show()
    }
}