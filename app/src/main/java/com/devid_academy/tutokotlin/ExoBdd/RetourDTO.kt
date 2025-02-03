package com.devid_academy.tutokotlin.ExoBdd


import com.squareup.moshi.Json

data class RetourDTO(
    @Json(name = "retour")
    val retour: Int
)