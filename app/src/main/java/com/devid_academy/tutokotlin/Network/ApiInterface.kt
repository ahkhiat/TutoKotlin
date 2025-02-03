package com.devid_academy.tutokotlin.Network

import com.devid_academy.tutokotlin.ExoBdd.GetCountriesDTO
import com.devid_academy.tutokotlin.ExoBdd.GetCountryDTO
import com.devid_academy.tutokotlin.ExoBdd.RetourDTO
import com.devid_academy.tutokotlin.ExoBdd.UpdateCountryDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {
    @GET(ApiRoutes.GET_ALL_COUNTRY)
    fun getAllCountry(@Query("id_s") stagiaireId: Long): Call<GetCountriesDTO>?

    @FormUrlEncoded // pour gérer les accents
    @POST(ApiRoutes.ADD_COUNTRY)
    fun insertCountry(
        @Field("nom") countryName: String,
        @Field("url") imageUrl : String,
        @Field("id_s") stagiaireId: Long
    ): Call<RetourDTO>

    @GET(ApiRoutes.GET_COUNTRY)
    fun getCountry(@Query("id") countryId: Long): Call<GetCountryDTO>?

    @POST(ApiRoutes.UPDATE_COUNTRY)
    fun updateCountry(@Body updateCountry: UpdateCountryDTO): Call<RetourDTO>?

    @FormUrlEncoded
    @POST(ApiRoutes.DELETE_COUNTRY)
    fun deleteCountry(@Field("id") countryId: Long): Call<RetourDTO>?

}