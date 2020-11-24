package com.example.onlinebus.room

import androidx.room.*
import com.example.onlinebus.entity.*

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User): Long

    @Delete
    fun deleteItem(user: User)


    @Transaction
    @Query("Select * FROM users WHERE userId =:cUserId ")
    fun getUser(cUserId: Long): User


}