package com.example.onlinebus.room

import androidx.room.*
import com.example.onlinebus.entity.Place

@Dao
interface PlaceDao {

    @Insert
    fun insertPlace(place: Place)

    @Delete
    fun deleteItem(place: Place)

    @Transaction
    @Query("Select * FROM places")
    fun getTrip(): List<Place>



}