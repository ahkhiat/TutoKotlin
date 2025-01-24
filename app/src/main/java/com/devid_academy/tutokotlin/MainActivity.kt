package com.devid_academy.tutokotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val tvNom = findViewById(R.id.tv_nom_main) as TextView

    val tvPrenom = findViewById<TextView>(R.id.tv_prenom_main)

    val btn : Button = findViewById(R.id.btn_main)

    tvNom.text = "gnagna"
    }
}