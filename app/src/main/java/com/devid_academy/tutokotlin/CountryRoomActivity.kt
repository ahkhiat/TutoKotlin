package com.devid_academy.tutokotlin

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class CountryRoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_room)

        val cr = CountryRoom(id = 0, countryName = "France", urlFlag = "https://cdn.countryflags.com/thumbs/brazil/flag-800.png")
        DemoAsyncTask().execute(cr)

//        MyApp.db.countryRoomDao().insert(cr)

//        val countries : List<CountryRoom> = MyApp.db.countryRoomDao().getAll()

    }

    private class DemoAsyncTask : AsyncTask<CountryRoom, Unit, String>() {
        override fun doInBackground(vararg countries: CountryRoom): String {
            Thread.sleep(1000)
            return "le nom du pays est : ${countries[0].countryName}"
        }

        override fun onPostExecute(result: String) {
            super.onPostExecute(result)
            Log.i("DemoAsyncTask", result)
        }
    }



}