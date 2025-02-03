package com.devid_academy.tutokotlin.Network

import android.content.ContentValues.TAG
import android.util.Log
import com.devid_academy.tutokotlin.ExoBdd.GetCountriesDTO
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiService {

    private fun getClient() : Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val moshi = Moshi.Builder().apply {
            add(KotlinJsonAdapterFactory())
        }.build()

        return Retrofit.Builder()
            .baseUrl(ApiRoutes.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()
    }
    fun getApi() = getClient().create(ApiInterface::class.java)
}

fun getRemoteCountries() {
    val call: Call<GetCountriesDTO>? = ApiService.getApi().getAllCountry(10)
    call?.enqueue(object : Callback<GetCountriesDTO> {
        override fun onResponse(call: Call<GetCountriesDTO>, response: Response<GetCountriesDTO>) {
            response.body()?.let {
                var infos = "status = "  + it.status
                it.countries.forEach { country -> infos += "\n" + country.nom }
                Log.i(TAG, infos)
            }
        }

        override fun onFailure(call: Call<GetCountriesDTO>, t: Throwable) {
            Log.e(TAG, t?.message ?: "boo, error")
        }

    })
}