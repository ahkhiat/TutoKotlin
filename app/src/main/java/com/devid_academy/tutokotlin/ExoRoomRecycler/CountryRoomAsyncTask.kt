package com.devid_academy.tutokotlin.ExoRoomRecycler

import android.os.AsyncTask
import com.devid_academy.tutokotlin.CountryRoom
import com.devid_academy.tutokotlin.MyApp

class GetAllCountryRoomAsyncTask(val onFinish: MyCallback) : AsyncTask<Unit,Unit,List<CountryRoom>>() {
    override fun doInBackground(vararg params: Unit?) : List<CountryRoom>{
       return MyApp.db.countryRoomDao().getAll()
    }

    override fun onPostExecute(result: List<CountryRoom>) {
        super.onPostExecute(result)
        onFinish.onAction(result)
    }
}

class InsertCountryRoomAsyncTask(val onFinish: ()->Unit): AsyncTask<CountryRoom,Unit,Unit>() {
    override fun doInBackground(vararg countries: CountryRoom) {
        countries.firstOrNull()?.let { country ->
            MyApp.db.countryRoomDao().insert(country)
        }    }

    override fun onPostExecute(result: Unit?) {
        super.onPostExecute(result)
        onFinish()
    }

}