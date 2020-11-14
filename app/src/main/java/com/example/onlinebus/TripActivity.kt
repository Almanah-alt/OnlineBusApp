package com.example.onlinebus

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlinebus.adapter.TripListAdapter
import com.example.onlinebus.room.AppDatabase
import kotlinx.android.synthetic.main.activity_trip.*

class TripActivity : AppCompatActivity() {
    companion object{
        const val BUS_ID = "busID"
        const val TRIP_ID = "tripID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip)
        toolbarSettings()

        loadTripList()

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun toolbarSettings(){
        supportActionBar!!.title = getString(R.string.flight_label)
        supportActionBar!!.setDisplayShowHomeEnabled(true);
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);
    }

    private fun loadTripList(){
        bus_trip_list.layoutManager = LinearLayoutManager(this)
        AsyncTask.execute {
            val tripList = AppDatabase.getInstance(applicationContext)
                ?.getTripDao()?.getTripWithBus()
            runOnUiThread{
                bus_trip_list.adapter = tripList?.let {
                    TripListAdapter(itemList = it, onTripClick = { item ->
                        val intent = Intent(this, BookingPlaceActivity::class.java)
                        intent.putExtra(BUS_ID, item.bus.busId)
                        intent.putExtra(TRIP_ID, item.trip.tripId)
                        startActivity(intent)
                    }, currentActivity = this)
                }
            }

        }
    }
}