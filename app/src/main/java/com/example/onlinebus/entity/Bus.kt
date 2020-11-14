package com.example.onlinebus.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "buses")
data class Bus(
    @PrimaryKey @ColumnInfo(name = "busId") val busId: Long? = null,
    @ColumnInfo(name = "busTripId") val busTripId: Long,
    @ColumnInfo(name = "stateLicensePlate") val stateLicensePlate: String,
    @ColumnInfo(name = "releaseYear") val releaseYear: String,
    @ColumnInfo(name = "busModel") val busModel: String,
    @ColumnInfo(name = "ferryman") val ferryman: String,
    @ColumnInfo(name = "admin") val admin: String,
    @ColumnInfo(name = "phone1") val phone1: String,
    @ColumnInfo(name = "phone2") val phone2: String,
    @ColumnInfo(name = "tripDuration") val tripDuration: Int,
    @ColumnInfo(name = "averagePrice") val averagePrice: Int


)