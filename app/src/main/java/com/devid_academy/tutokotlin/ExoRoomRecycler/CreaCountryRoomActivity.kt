package com.devid_academy.tutokotlin.ExoRoomRecycler

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.devid_academy.tutokotlin.CountryRoom
import com.devid_academy.tutokotlin.R

class CreaCountryRoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crea_country_room)

        var etCountryName: EditText = findViewById(R.id.cca_input_country_name)
        val etCountryUrlFlag: EditText = findViewById(R.id.cca_input_url)

        findViewById<Button>(R.id.cca_button_validate).setOnClickListener {
            val countryName = etCountryName.text.toString().trim()
            val countryFlag = etCountryUrlFlag.text.toString().trim()

            if(countryName.isNotEmpty() && countryFlag.isNotEmpty())
                InsertCountryRoomAsyncTask(
                    onFinish = {
                        setResult(RESULT_OK)
                        finish()
                    }
                ).execute(CountryRoom(0, countryName, countryFlag))

        }


    }
}