package com.devid_academy.tutokotlin.ExoBdd


import com.squareup.moshi.Json

data class GetCountriesDTO(
    @Json(name = "countries")
    val countries: List<CountryDTO>,
    @Json(name = "status")
    val status: String
)