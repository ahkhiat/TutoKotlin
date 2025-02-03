package com.devid_academy.tutokotlin.ExoBdd


import com.squareup.moshi.Json

data class CountryDTO(
    @Json(name = "id")
    val id: Long,
    @Json(name = "id_stagiaire")
    val idStagiaire: Long,
    @Json(name = "nom")
    val nom: String,
    @Json(name = "url")
    val url: String
)