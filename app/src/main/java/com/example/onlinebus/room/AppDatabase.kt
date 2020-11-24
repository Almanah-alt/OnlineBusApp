package com.example.onlinebus.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.onlinebus.entity.*

@Database(entities = [Trip::class, Bus::class, Place::class, User::class, UserCard::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getTripDao(): TripDao
    abstract fun getBusDao(): BusDao
    abstract fun getPlaceDao(): PlaceDao
    abstract fun getUserDao(): UserDao
    abstract fun getUserCardDao(): UserCardDao

    companion object{
        private const val DB_NAME = "onlineBus.db"
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase? {
            if(instance == null){
                instance = Room.databaseBuilder(context,
                    AppDatabase::class.java, DB_NAME).build()
            }
            return instance
        }
    }
}