package com.example.onlinebus.entity

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithCads (
    @Embedded var user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "cardOwnerId"
    )
    var userCardList: List<UserCard>
)