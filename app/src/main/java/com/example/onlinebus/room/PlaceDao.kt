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
    fun getPlace(): List<Place>

    @Transaction
    @Query("Select * FROM places WHERE placeId = :id ")
    fun getPlacePlaceID(id: Long): Place


    @Transaction
    @Query("UPDATE places SET  status =:status WHERE placeId =:id ")
    fun updateStatusPlacePlaceID(id: Long, status: Boolean)




}