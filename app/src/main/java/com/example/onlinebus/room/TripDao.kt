package com.example.onlinebus.room

import androidx.room.*
import com.example.onlinebus.entity.Trip
import com.example.onlinebus.entity.TripWithBus
import kotlinx.coroutines.selects.select

@Dao
interface TripDao {

    @Insert
    fun insertTrip(trip: Trip): Long

    @Delete
    fun deleteItem(trip: Trip)

    @Transaction
    @Query("Select * FROM trips")
    fun getTripWithBus(): List<TripWithBus>

    @Transaction
    @Query("Select * FROM trips WHERE tripId = :id")
    fun getTripWithBus(id: Long): TripWithBus



}