package com.nikolay.oauth2app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val username = "pib123"
    private val password = "pib123"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_run_2.setOnClickListener {
            val auth = OAuth()
            Log.d("response2", auth.tokenRequest(username, password).toString())
            print(12)
        }
    }

}
