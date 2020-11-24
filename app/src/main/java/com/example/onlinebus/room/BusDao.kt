package com.example.onlinebus.room

import androidx.room.*
import com.example.onlinebus.entity.Bus
import com.example.onlinebus.entity.BusWithPlaces

@Dao
interface BusDao {

    @Insert
    fun insertBus(bus: Bus): Long

    @Delete
    fun deleteItem(bus: Bus)

    @Transaction
    @Query("Select * FROM buses WHERE busId = :id")
    fun getBusWithPlacesByBusId(id: Long): BusWithPlaces

    @Transaction
    @Query("Select * FROM buses")
    fun getBusWithPlaces(): List<BusWithPlaces>




}