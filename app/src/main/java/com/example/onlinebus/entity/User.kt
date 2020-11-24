package com.example.onlinebus.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey @ColumnInfo(name = "userId") val userId: Long? = null,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "iin") val iin: String,
    @ColumnInfo(name = "placeId") val placeId: Long? = null,
    @ColumnInfo(name = "tripId") val tripId: Long? = null



)