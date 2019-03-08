package com.nikolay.oauth2app

import android.util.Base64

class Util{
    companion object {
        fun getAuthHeader(): String {
            val auth = "${Constants.CLIENT_ID}:${Constants.CLIENT_SECRET}"
            return String.format(
                Constants.AUTH_TOKEN_BASIC_FORMAT, String(android.util.Base64.encode(auth.toByteArray(), Base64.DEFAULT))
                    .replace(Constants.NEW_LINE, Constants.STRING_EMPTY)
            )
        }
    }
}