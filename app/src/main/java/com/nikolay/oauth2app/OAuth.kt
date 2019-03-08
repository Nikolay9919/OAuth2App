package com.nikolay.oauth2app

import android.os.Build
import android.os.StrictMode
import android.util.Log
import com.nikolay.oauth2app.Util.Companion.getAuthHeader
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.text.SimpleDateFormat
import java.util.*

class OAuth {
    private var client = OkHttpClient()


    fun tokenRequest(username: String, password: String): Response {
        val strictMode = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(strictMode)
        client = OkHttpClient()
        val formBody = FormBody.Builder()
            .add("username", username)
            .add("password", password)
            .add(Constants.GRANT_TYPE, Constants.GRANT_TYPE_PASSWORD)
            .add(Constants.SCOPE, Constants.OAUTH_APP_SCOPE)
            .build()
        val request = Request.Builder()
            .addHeader(Constants.HTTP_HEADER_CHANEL, Constants.CHANEL)
            .addHeader(Constants.HTTP_HEADER_APPLICATION_VERSION, "194")
            .addHeader(Constants.HTTP_HEADER_DEVICE_ID, "fd09b975-2a3b-4dae-add5-c458bddc993f")
            .addHeader(Constants.HTTP_HEADER_ACCEPT_LANG, "bg")
            .addHeader(
                Constants.HTTP_HEADER_TIMESTAMP,
                SimpleDateFormat(Constants.SERVER_DATE_FORMAT, Locale.US).format(Calendar.getInstance().time)
            )
            .addHeader(Constants.HTTP_HEADER_CLIENT_VERSION, Build.VERSION.RELEASE)
            .addHeader(Constants.HEADER_ACCEPT, "application/json")
            .addHeader(Constants.HTTP_HEADER_CONTENT_TYPE, Constants.contentType)
            .addHeader(Constants.HTTP_HEADER_THEME, "E_MOBILE")
            .addHeader(Constants.AUTHORIZATION, getAuthHeader())
            .addHeader(Constants.HTTP_HEADER_SCREEN, "LOGIN")
            .url(Constants.TOKEN_URL)
            .post(formBody)
            .build()
        Log.d("response", client.newCall(request).execute().message())
        return client.newCall(request).execute()

    }


}