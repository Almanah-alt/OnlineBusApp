package com.example.onlinebus.entity

import androidx.room.Embedded
import androidx.room.Relation

data class BusWithPlaces (
    @Embedded var bus: Bus,
    @Relation(
        parentColumn = "busId",
        entityColumn = "busPlaceId"
    )
    var placeList: List<Place>
)