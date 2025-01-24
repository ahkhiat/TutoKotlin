package com.devid_academy.tutokotlin

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val myPref = applicationContext
            .getSharedPreferences("TutoKotlin", Context.MODE_PRIVATE)

        // Si la clé existe, alors rdirectin vers Main, sinon redirection vers Login

    }
}