package com.devid_academy.tutokotlin

import androidx.room.ColumnInfo
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomDatabase

@Database(entities = [CountryRoom::class], version = 1, exportSchema = false)
abstract class AppDatabase() : RoomDatabase() {
    abstract fun countryRoomDao(): CountryRoomDao
}

@Entity(tableName = "country_room")
data class CountryRoom(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name= "id") val id: Long = 0,
    @ColumnInfo(name= "name") val countryName: String,
    @ColumnInfo(name= "url_flag") val urlFlag: String

    )