package com.nikolay.oauth2app

import android.os.Bundle
import android.os.StrictMode
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private var client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val strictMode = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(strictMode)





        btn_run.setOnClickListener {
            client = OkHttpClient()
            val formBody = MultipartBody.Builder()
                .addFormDataPart("username", "pib123")
                .addFormDataPart("password", "pib123")
                .addFormDataPart("client_id", "android")
                .addFormDataPart("client_secret", "android_secret")
                .addFormDataPart("redirect_uri", "%2FEBank%2F")
                .addFormDataPart("scope", "E_BANK")
                .build()
            val request = Request.Builder()
                .url("https://my.fibank.bg/oauth2-server/oauth/token")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .post(formBody)
                .build()
            Log.d("response", request.toString())

            val response = client.newCall(request).execute()

            if (!response.isSuccessful) throw  IOException("Unexpected code $response")

        }
    }
}
