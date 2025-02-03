package com.devid_academy.tutokotlin.ExoBdd

import android.content.ContentValues.TAG
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devid_academy.tutokotlin.CountryRoom
import com.devid_academy.tutokotlin.ExoRoomRecycler.MyCallback
import com.devid_academy.tutokotlin.Network.getRemoteCountries
import com.devid_academy.tutokotlin.R
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class BddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bdd)

        TestConnectionAsyncTask().execute("https://formation.dev2.dev-id.fr/get_countries.php?id_s=3")

        getRemoteCountries()






    }
}

class TestConnectionAsyncTask : AsyncTask<String, Unit, String>() {

    override fun doInBackground(vararg params: String): String {

        val url = URL(params[0])
        val urlConnection = url.openConnection() as HttpURLConnection

        urlConnection.requestMethod = "GET"
        urlConnection.doInput = true
        urlConnection.connect()
        val inputS = urlConnection.inputStream
        val sb = StringBuilder()
        if (inputS != null) {
            val reader = BufferedReader(InputStreamReader(inputS))
            var line = reader.readLine()
            while (line != null) {
                sb.append(line)
                line = reader.readLine()
            }
            reader.close()
            inputS.close()
        }
        return sb.toString()
    }

    override fun onPostExecute(result: String) {
        super.onPostExecute(result)
        Log.i("TestConnectionAsyncTask fonctionne", result)

        try {
            var myJson = JSONObject(result)
            var infos = myJson.getString("status")
            val jArray = myJson.getJSONArray("countries")

            for (i in 0 until jArray.length()) {
                val jsonObj = jArray.getJSONObject(i)
                infos += " /" + jsonObj.getString("nom")
            }
            Log.i(TAG, infos)
        } catch(e: JSONException) {
            Log.e(TAG, "Problème de parse :" + e.message)
        }





//        try {
//            myJson = result
//        }catch (){

//        }



    }

}