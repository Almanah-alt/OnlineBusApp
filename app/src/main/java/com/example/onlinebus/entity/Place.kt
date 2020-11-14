package com.example.onlinebus.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "places")
data class Place (
    @PrimaryKey @ColumnInfo(name = "placeId") val placeId: Long? = null,
    val busPlaceId: Long,
    val placeNum: Int,
    val placePrice: Int,
    val status: Boolean = true
)