package com.devid_academy.tutokotlin

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myPref = applicationContext
            .getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

        val tvNom: TextView = findViewById(R.id.tv_nom_main)
        val btnLogout = findViewById<Button>(R.id.btn_logout)

        val nameFromSP = myPref.getString(NAME_KEY, null) ?: ""

        val receivedName = intent.getStringExtra(NAME_KEY) ?: ""
        if(receivedName.isNotEmpty()) {
            tvNom.text = "Bonjour $receivedName"
        }

        btnLogout.setOnClickListener{
            myPref.edit().remove(NAME_KEY).apply()
            val intent = Intent(this@MainActivity, SplashActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}