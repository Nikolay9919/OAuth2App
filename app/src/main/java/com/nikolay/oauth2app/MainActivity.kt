package com.nikolay.oauth2app

import android.os.Bundle
import android.os.StrictMode
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : AppCompatActivity() {

    private var client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val strictMode = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(strictMode)
        val clientSecret = "android_secret"
        val clientId = "android"
        val contentType = "application/x-www-form-urlencoded"
        val TOKEN_URL = "https://myzxc.fibank.bg:443/oauth2-server/oauth/token"
        val HEADER_OAUTH_APP_SCOPE = "read"
        val HEADER_EBANK_SYSTEM_ID = "MY-FIBANK.BG"
        val GRANT_TYPE_PASSWORD = "password"
        val username = "pib123"
        val password = "pib123"
        val HEADER_ACCEPT = "Accept"
        val HEADER_CONTENT_TYPE = "Content-Type"
        val HEADER_AUTHORIZATION = "Authorization"


        btn_run.setOnClickListener {
            val strictMode = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(strictMode)
            //            val client = OAuth2Client.Builder(username,password,clientId,clientSecret,)

            val auth = "$clientId:$clientSecret"
            client = OkHttpClient.Builder()
                .hostnameVerifier { _, _ ->
                    return@hostnameVerifier true
                }
                .build()

            val request = Request.Builder()
                .url(TOKEN_URL)
                .addHeader(
                    HEADER_AUTHORIZATION,
                    String.format("Basic ${Basic.encode("$username:$password".toByteArray())}")
                )
                .addHeader("Scope", HEADER_OAUTH_APP_SCOPE)
                .addHeader("grant_type", GRANT_TYPE_PASSWORD)
                .addHeader(HEADER_ACCEPT, "application/json, application/x-www-form-urlencoded")
                .addHeader(HEADER_CONTENT_TYPE, contentType)
                .addHeader("username", username)
                .addHeader("password", password)
                .build()
            Log.d("request", request.headers().toString())
            Log.d("request", request.toString())

            val response = client.newCall(request).execute()

            Log.d("response", response.toString())


        }

        btn_run_2.setOnClickListener {


            val mediaType = MediaType.parse("application/x-www-form-urlencoded")

            client = OkHttpClient()
            val formBody = MultipartBody.Builder()
                .setType(mediaType)
                .addFormDataPart("client_id", "android")
                .addFormDataPart("client_secret", "android_secret")
                .addFormDataPart("username", "pib123")
                .addFormDataPart("password", "pib123")
                .build()
            val request = Request.Builder()
                .url("https://my.fibank.bg/oauth2-server/oauth/token")
                .post(formBody)
                .build()
            Log.d("response", client.newCall(request).execute().message())
            val response = client.newCall(request).execute()

            Log.d("response2", response.toString())
        }
    }

}
