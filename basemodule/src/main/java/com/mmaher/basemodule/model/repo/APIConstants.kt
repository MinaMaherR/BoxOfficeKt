package com.mmaher.basemodule.model.repo

import com.mmaher.basemodule.BuildConfig

/**
 * Created by Mina Maher (m.maher95@outlook.com) on 2020-02-21.
 */
interface APIConstants {
    companion object {
        // Headers
        val bearerHeaderKeyword = "Bearer"
        val authorizationHeaderKey = "Authorization"
        val authorizationHeaderValue = "$bearerHeaderKeyword ${BuildConfig.TOKEN}"
    }
}