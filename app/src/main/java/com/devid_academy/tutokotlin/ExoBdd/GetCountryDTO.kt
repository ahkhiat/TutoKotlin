package com.devid_academy.tutokotlin.ExoBdd


import com.squareup.moshi.Json

data class GetCountryDTO(
    @Json(name = "country")
    val country: GetCountry2DTO,
    @Json(name = "status")
    val status: String
)