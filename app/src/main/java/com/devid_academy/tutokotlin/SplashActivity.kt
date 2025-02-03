package com.devid_academy.tutokotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        val myPref = applicationContext
            .getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

        // Si la clé existe, alors rdirectin vers Main, sinon redirection vers Login

        val nameFromSP = myPref.getString(NAME_KEY, null) ?: ""

        Handler().postDelayed({
            val intent = if(nameFromSP.isNotEmpty()) {
                Intent(this@SplashActivity, MainActivity::class.java).apply {
                    putExtra(NAME_KEY, nameFromSP)
                }
            } else {
                Intent(this@SplashActivity, FormActivity::class.java)
            }
            startActivity(intent)
            finish()
        }, 3000)

        // Attention, trop de variables temporaires

        // méthode optimisée

//        applicationContext
//            .getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
//            .let{
//                if((it.getString(NAME_KEY, null) ?: "").isNotEmpty() {
//                        Intent(this@SplashActivity, MainActivity::class.java).apply {
//                            putExtra(NAME_KEY, nameFromSP)
//                    })
//            }



    }
}