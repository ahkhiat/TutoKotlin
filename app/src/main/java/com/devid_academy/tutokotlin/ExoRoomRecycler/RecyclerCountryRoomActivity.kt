package com.devid_academy.tutokotlin.ExoRoomRecycler

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devid_academy.tutokotlin.CountryRoom
import com.devid_academy.tutokotlin.MyApp
import com.devid_academy.tutokotlin.R

class RecyclerCountryRoomActivity : AppCompatActivity() {
    private lateinit var  countryRoomAdapter: CountryRoomAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_country_room)

        progressBar = findViewById(R.id.progressBar2)

        // insertion d'un element
//        InsertCountryRoomAsyncTask().execute(CountryRoom(0, "France", "https://cdn.countryflags.com/thumbs/france/flag-800.png"))

        countryRoomAdapter = CountryRoomAdapter()

        recyclerView = findViewById<RecyclerView>(R.id.rv_country).apply {
            layoutManager = LinearLayoutManager(this@RecyclerCountryRoomActivity)
            adapter = countryRoomAdapter
        }

        val registerCreateCountryRoom =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if(result.resultCode == RESULT_OK)
                    refresh()
        }

        findViewById<Button>(R.id.btn_rva_add_country).setOnClickListener {
            registerCreateCountryRoom.launch(Intent(this, CreaCountryRoomActivity::class.java))
        }

        refresh()

        }

    private fun refresh() {
        progressBar.visibility = View.VISIBLE
        GetAllCountryRoomAsyncTask { a ->
            countryRoomAdapter.setCountries(a as List<CountryRoom>)
            recyclerView.scrollToPosition(countryRoomAdapter.itemCount - 1)
            progressBar.visibility = View.GONE
        }.execute()
    }


}