package com.example.onlinebus

import android.os.AsyncTask
import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.onlinebus.entity.Bus
import com.example.onlinebus.entity.Place
import com.example.onlinebus.entity.Trip
import com.example.onlinebus.room.AppDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

//        insertDb()

    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun insertDb(){

        AsyncTask.execute {


            val currentTripId = AppDatabase.getInstance(applicationContext)!!.getTripDao().insertTrip(
                Trip(fromCity = "Almaty", toCity = "Astana", depDay = "12.10.2020", depHour = 23, depMinute = 0, arrDay = "14.10.2020", arrHour = 14, arrMinute = 30
                )
            )

            val currentBusId = AppDatabase.getInstance(applicationContext)!!.getBusDao().insertBus(
               Bus(stateLicensePlate = "123Ab05", releaseYear = "2012", admin = "Admin", ferryman = "Someone", phone2 = "8 888 888 88 88", phone1 = "8 777 777 77 77", averagePrice = 1500, busModel = "Mercedes", tripDuration = 24, busTripId = currentTripId)
            )

            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 1, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 2, placePrice = 1500, busPlaceId = currentBusId, status = false)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 3, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 4, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 5, placePrice = 1500, busPlaceId = currentBusId, status = false)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 6, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 7, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 8, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 9, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 10, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 11, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 12, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 13, placePrice = 1500, busPlaceId = currentBusId, status = false)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 14, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 15, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 16, placePrice = 1500, busPlaceId = currentBusId, status = false)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 17, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 18, placePrice = 1500, busPlaceId = currentBusId, status = false)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 19, placePrice = 1500, busPlaceId = currentBusId, status = false)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 20, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 21, placePrice = 1500, busPlaceId = currentBusId, status = false)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 22, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 23, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 24, placePrice = 1500, busPlaceId = currentBusId, status = false)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 25, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 26, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 27, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 28, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 29, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 30, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 31, placePrice = 1500, busPlaceId = currentBusId, status = false)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 32, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 33, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 34, placePrice = 1500, busPlaceId = currentBusId, status = false)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 35, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 36, placePrice = 1500, busPlaceId = currentBusId, status = false)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 37, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 38, placePrice = 1500, busPlaceId = currentBusId)
            )
            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().insertPlace(
                Place(placeNum = 39, placePrice = 1500, busPlaceId = currentBusId)
            )
        }
    }
}