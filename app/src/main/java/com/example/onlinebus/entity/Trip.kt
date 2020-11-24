package com.example.onlinebus.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.onlinebus.R

@Entity(tableName = "trips")
data class Trip(
    @PrimaryKey @ColumnInfo(name = "tripId") val tripId: Long? = null,
    @ColumnInfo(name = "userTripId") val userTripId: Long? = null,
    @ColumnInfo(name = "from_city") val fromCity: String,
    @ColumnInfo(name = "to_city") val toCity: String,
    @ColumnInfo(name = "departure_day") val depDay: String,
    @ColumnInfo(name = "departure_hours") val depHour: Int,
    @ColumnInfo(name = "departure_minute") val depMinute: Int,
    @ColumnInfo(name = "arrival_day") val arrDay: String,
    @ColumnInfo(name = "arrival_hours") val arrHour: Int,
    @ColumnInfo(name = "arrival_Minute") val arrMinute: Int
)