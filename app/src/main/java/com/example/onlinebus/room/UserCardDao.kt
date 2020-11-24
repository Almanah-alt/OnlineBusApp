package com.example.onlinebus.room

import androidx.room.*
import com.example.onlinebus.entity.*

@Dao
interface UserCardDao {

    @Insert
    fun insertUserCard(userCard: UserCard): Long

    @Delete
    fun deleteItem(userCard: UserCard)

    @Transaction
    @Query("Select * FROM userCards")
    fun getUserCards(): List<UserCard>



}