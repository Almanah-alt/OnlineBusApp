package com.example.onlinebus

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onlinebus.entity.User
import com.example.onlinebus.room.AppDatabase
import kotlinx.android.synthetic.main.fragment_booking_detail.*

class BookingDetailActivity : AppCompatActivity() {
    companion object{
        const val CURRENT_USER_ID = "current_user_id"
    }

    private var userId: Long = 0
    private var tripId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.fragment_booking_detail)
        super.onCreate(savedInstanceState)
        toolbarSettings()

        val placeNum: Int = intent.getIntExtra(BookingPlaceActivity.PLACE_NUM, 0)
        val placePrice = intent.getIntExtra(BookingPlaceActivity.PLACE_PRICE, 0)
        val placeID = intent.getLongExtra(BookingPlaceActivity.PLACE_ID, 0)
        tripId = intent.getLongExtra(TripActivity.TRIP_ID, 0)


        fillPlaceInfo(placeNum, placePrice)
        next_to_payment_btn.setOnClickListener {
            handleUserData(placeID)
            val intent = Intent(this, PaymentActivity::class.java)
            intent.putExtra(CURRENT_USER_ID, userId)
            intent.putExtra(BookingPlaceActivity.PLACE_ID, placeID)
            intent.putExtra(TripActivity.TRIP_ID, tripId)
            startActivity(intent)
        }

    }
    @SuppressLint("SetTextI18n")
    private fun fillPlaceInfo(placeID: Int, placePrice: Int){
        bus_place_id.text = "$placeID"
        place_price.text = "$placePrice тг"
        bus_place_cost.text = "$placePrice тг"
        service_cost.text = "0 тг"
        bus_total_price_cost.text = "$placePrice тг"
    }

    private fun handleUserData(placeID: Long){

        AsyncTask.execute{

            val placeIDDB = AppDatabase.getInstance(applicationContext)!!.getPlaceDao().getPlacePlaceID(placeID)
            val bus = AppDatabase.getInstance(applicationContext)!!.getBusDao().getBusWithPlacesByBusId(placeIDDB.busPlaceId)
            val currentUserId = AppDatabase.getInstance(applicationContext)!!.getUserDao().insertUser(
                User(name = user_first_last_name.text.toString(), phone = user_phone_number.text.toString(), iin = user_IIN.text.toString(),
                    email = user_email.text.toString(), tripId = bus.bus.busTripId, placeId = placeID )
            )
            userId = currentUserId
        }

    }

    private fun toolbarSettings(){
        supportActionBar!!.title = getString(R.string.toolbar_passengers)
        supportActionBar!!.setDisplayShowHomeEnabled(true);
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}