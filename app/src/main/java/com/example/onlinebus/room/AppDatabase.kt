package com.example.onlinebus.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.onlinebus.entity.Bus
import com.example.onlinebus.entity.Place
import com.example.onlinebus.entity.Trip

@Database(entities = [Trip::class, Bus::class, Place::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getTripDao(): TripDao
    abstract fun getBusDao(): BusDao
    abstract fun getPlaceDao(): PlaceDao

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