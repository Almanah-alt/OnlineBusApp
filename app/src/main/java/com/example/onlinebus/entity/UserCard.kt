package com.example.onlinebus.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userCards")
data class UserCard(
    @PrimaryKey @ColumnInfo(name = "userCardId") val userCardId: Long? = null,
    @ColumnInfo(name = "cardOwnerId") val cardOwnerId: Long,
    @ColumnInfo(name = "cardNumber") val cardNumber: String,
    @ColumnInfo(name = "ownerName") val ownerName: String,
    @ColumnInfo(name = "expDate") val expDate: String,
    @ColumnInfo(name = "cvc") val cvc: String


)