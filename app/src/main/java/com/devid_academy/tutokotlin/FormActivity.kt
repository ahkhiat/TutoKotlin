package com.devid_academy.tutokotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val tvName = findViewById<TextView>(R.id.tv_name_form_act)
        val btnLogin = findViewById<Button>(R.id.btn_login)

        btnLogin.setOnClickListener {

            val myPref = applicationContext
                .getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

            val name = tvName.text.toString()

            myPref.edit()
                .putString(NAME_KEY, name )
                .apply()

            val intent = Intent(this@FormActivity, MainActivity::class.java)
            intent.putExtra(NAME_KEY, name)
            startActivity(intent)


        }


    }
}