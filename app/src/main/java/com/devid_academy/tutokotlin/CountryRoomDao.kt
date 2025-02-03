package com.devid_academy.tutokotlin

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CountryRoomDao {
    @Query("SELECT * FROM country_room")
    fun getAll() : List<CountryRoom>
    // chaque ligne de la bdd crée une instance de la data class CountryRom

    @Query("SELECT * FROM country_room WHERE name LIKE :countryName LIMIT 1")
    fun findByName(countryName: String) : CountryRoom

    @Update
    fun update(countryRoom: CountryRoom)

    @Insert
    fun insert(countryRoom: CountryRoom)

    @Delete
    fun delete(countryRoom: CountryRoom)

}