package com.example.onlinebus

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.example.onlinebus.entity.Trip
import com.example.onlinebus.room.AppDatabase
import kotlinx.android.synthetic.main.fragment_order_detail.*
import kotlinx.android.synthetic.main.success_payment_alert_dialog.view.*
import java.util.*

class OrderDetailActivity : AppCompatActivity() {
    private var userId: Long = 0
    private var placeId: Long = 0
    private var tripId: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.fragment_order_detail)
        super.onCreate(savedInstanceState)

        toolbarSettings()
        userId = intent.getLongExtra(BookingDetailActivity.CURRENT_USER_ID, 0)
        placeId = intent.getLongExtra(BookingPlaceActivity.PLACE_ID, 0)
        tripId = intent.getLongExtra(TripActivity.TRIP_ID, 0)
        fillOrderDetail(userId)

    }

    @SuppressLint("SetTextI18n")
    private fun fillOrderDetail(id : Long){
        AsyncTask.execute{
            val user = AppDatabase.getInstance(applicationContext)!!.getUserDao().getUser(id)
            val userPlace =
                    AppDatabase.getInstance(applicationContext)!!.getPlaceDao().getPlacePlaceID(
                        placeId
                    )
            val userTrip =
                    AppDatabase.getInstance(applicationContext)!!.getTripDao().getTripById(
                        tripId
                    )
            runOnUiThread {
                val c = Calendar.getInstance()
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)

                val hour = c.get(Calendar.HOUR_OF_DAY)
                val minutes = c.get(Calendar.MINUTE)

                first_city.text = userTrip.fromCity
                second_city.text = userTrip.toCity


//                if (userPlace.placePrice != null){
//                    order_detail_total_price.text = "${userPlace.placePrice}"
//                    order_detail_total_tarif.text = "${userPlace.placePrice}"
//                    }else {
//                    order_detail_passenger_name.text = "3000 т"
//                    order_detail_total_tarif.text = "3000 т"
//                }
//
//                if (user.name != null){
//                    order_detail_passenger_name.text = user.name
//                    }else order_detail_passenger_name.text = "aaa"
//
//                if (userPlace.placeNum != null){
//                    order_detail_place_id.text = "${userPlace.placeNum}"
//                    }else order_detail_place_id.text = "20"


                order_detail_day.text = "${day}.${month}.${year}"
                if (minutes <= 9){
                    order_detail_time.text = "${hour}:0${minutes}"
                }else order_detail_time.text = "${hour}:${minutes}"
            }
        }
    }

    private fun toolbarSettings(){
        supportActionBar!!.title = getString(R.string.order_detail_toolbar_title)
        supportActionBar!!.setDisplayShowHomeEnabled(true);
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}