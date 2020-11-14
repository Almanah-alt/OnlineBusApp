package com.example.onlinebus.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation


data class TripWithBus(
    @Embedded var trip: Trip,
    @Relation(
        parentColumn = "tripId",
        entityColumn = "busTripId"
    )
    var bus: Bus
)