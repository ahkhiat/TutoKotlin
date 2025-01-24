package com.devid_academy.tutokotlin

import android.content.Context
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

            val name = tvName.text.toString()


        }


    }
}