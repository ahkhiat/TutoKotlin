package com.devid_academy.tutokotlin.ExoBdd


import com.squareup.moshi.Json

data class GetCountry2DTO(
    @Json(name = "id")
    val id: Int,
    @Json(name = "id_stagiaire")
    val idStagiaire: Int,
    @Json(name = "nom")
    val nom: String,
    @Json(name = "url")
    val url: String
)