package com.nikolay.oauth2app

import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.support.v7.app.AppCompatActivity
import android.util.Base64
import android.util.Log
import com.nikolay.oauth2app.Constants.Companion.AUTHORIZATION
import com.nikolay.oauth2app.Constants.Companion.AUTH_TOKEN_BASIC_FORMAT
import com.nikolay.oauth2app.Constants.Companion.CHANEL
import com.nikolay.oauth2app.Constants.Companion.CLIENT_ID
import com.nikolay.oauth2app.Constants.Companion.CLIENT_SECRET
import com.nikolay.oauth2app.Constants.Companion.GRANT_TYPE
import com.nikolay.oauth2app.Constants.Companion.GRANT_TYPE_PASSWORD
import com.nikolay.oauth2app.Constants.Companion.HEADER_ACCEPT
import com.nikolay.oauth2app.Constants.Companion.HEADER_CONTENT_TYPE
import com.nikolay.oauth2app.Constants.Companion.HTTP_HEADER_ACCEPT_LANG
import com.nikolay.oauth2app.Constants.Companion.HTTP_HEADER_APPLICATION_VERSION
import com.nikolay.oauth2app.Constants.Companion.HTTP_HEADER_CHANEL
import com.nikolay.oauth2app.Constants.Companion.HTTP_HEADER_CLIENT_VERSION
import com.nikolay.oauth2app.Constants.Companion.HTTP_HEADER_DEVICE_ID
import com.nikolay.oauth2app.Constants.Companion.HTTP_HEADER_SCREEN
import com.nikolay.oauth2app.Constants.Companion.HTTP_HEADER_THEME
import com.nikolay.oauth2app.Constants.Companion.HTTP_HEADER_TIMESTAMP
import com.nikolay.oauth2app.Constants.Companion.NEW_LINE
import com.nikolay.oauth2app.Constants.Companion.OAUTH_APP_SCOPE
import com.nikolay.oauth2app.Constants.Companion.SCOPE
import com.nikolay.oauth2app.Constants.Companion.SERVER_DATE_FORMAT
import com.nikolay.oauth2app.Constants.Companion.STRING_EMPTY
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    private val username = "pib123"
    private val password = "pib123"
    private var client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val strictMode = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(strictMode)


        /*  btn_run.setOnClickListener {
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
                      AUTHORIZATION,
                      String.format("Basic %s", String(Base64.encode(auth.toByteArray(), Base64.DEFAULT)))
                  )
                  .addHeader("Scope", OAUTH_APP_SCOPE)
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


          }*/
        val auth = "$CLIENT_ID:$CLIENT_SECRET"
        val authHeader = String.format(
            AUTH_TOKEN_BASIC_FORMAT, String(android.util.Base64.encode(auth.toByteArray(), Base64.DEFAULT))
                .replace(NEW_LINE, STRING_EMPTY)
        )
        btn_run_2.setOnClickListener {


            //    val mediaType = MediaType.parse("application/x-www-form-urlencoded")

            client = OkHttpClient()
            val formBody = FormBody.Builder()
                .add("username", "pib123")
                .add("password", "pib123")
                .add(GRANT_TYPE, GRANT_TYPE_PASSWORD)
                .add(SCOPE, OAUTH_APP_SCOPE)
                .build()
            val request = Request.Builder()
                .addHeader(HTTP_HEADER_CHANEL, CHANEL)
                .addHeader(HTTP_HEADER_APPLICATION_VERSION, "194")
                .addHeader(HTTP_HEADER_DEVICE_ID, "fd09b975-2a3b-4dae-add5-c458bddc993f")
                .addHeader(HTTP_HEADER_ACCEPT_LANG, "bg")
                .addHeader(
                    HTTP_HEADER_TIMESTAMP,
                    SimpleDateFormat(SERVER_DATE_FORMAT, Locale.US).format(Calendar.getInstance().time)
                )
                .addHeader(HTTP_HEADER_CLIENT_VERSION, Build.VERSION.RELEASE)
                .addHeader(HEADER_ACCEPT, "application/json")
                .addHeader(HEADER_CONTENT_TYPE, "application/x-www-form-urlencoded")
                .addHeader(HTTP_HEADER_THEME, "E_MOBILE")
                .addHeader(AUTHORIZATION, authHeader)
                .addHeader(HTTP_HEADER_SCREEN, "LOGIN")
                .url("https://my.fibank.bg/oauth2-server/oauth/token")
                .post(formBody)
                .build()
            Log.d("response", client.newCall(request).execute().message())
            val response = client.newCall(request).execute()

            Log.d("response2", response.toString())
            print(12)
        }
    }

}
