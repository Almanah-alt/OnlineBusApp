package com.example.onlinebus


import android.annotation.SuppressLint
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.onlinebus.entity.Trip
import com.example.onlinebus.entity.UserCard
import com.example.onlinebus.room.AppDatabase
import kotlinx.android.synthetic.main.fragment_payment.*


class PaymentActivity : AppCompatActivity() {

    private var currentUserId: Long = 0
    private var tripId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        setContentView(R.layout.fragment_payment)
        super.onCreate(savedInstanceState)
        toolbarSettings()

        currentUserId = intent.getLongExtra(BookingDetailActivity.CURRENT_USER_ID, 0)
        tripId = intent.getLongExtra(TripActivity.TRIP_ID, 0)

        pay_btn.setOnClickListener {
            addCard(currentUserId)

        }
    }

    private fun addCard(userId: Long){
        AsyncTask.execute{
            val cardId = AppDatabase.getInstance(applicationContext)!!.getUserCardDao().insertUserCard(
                UserCard(cardOwnerId = userId, cardNumber = user_payment_card.text.toString(),
                    ownerName = payment_card_owner_name.text.toString(), expDate = user_card_expiration_date.text.toString(),
                cvc = user_card_cvc2_cvv2.text.toString())
            )
            runOnUiThread {
                successMessageDialog(userId)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun successMessageDialog(userId: Long){
        val alertDialog = Dialog(this)

        alertDialog.setContentView(R.layout.success_payment_alert_dialog)
        val btn = alertDialog.findViewById<TextView>(R.id.ok_btn)
        val textView = alertDialog.findViewById<TextView>(R.id.order_history_label)
        textView.text = "\"${getString(R.string.history_detail_label)}\""
        btn.setOnClickListener {
            alertDialog.dismiss()
            val intent = Intent(this, OrderDetailActivity::class.java )
            intent.putExtra(BookingDetailActivity.CURRENT_USER_ID, currentUserId)
            intent.putExtra(TripActivity.TRIP_ID, tripId)
            startActivity(intent)
        }
        alertDialog.show()
//
//        val user = AppDatabase.getInstance(applicationContext)!!.getUserDao().getUser(userId)
//        user.placeId?.let {
//            AppDatabase.getInstance(applicationContext)!!.getPlaceDao().updateStatusPlacePlaceID(
//                it, true
//            )
//        }


    }
    private fun toolbarSettings(){
        supportActionBar!!.title = getString(R.string.payment_toolbar_title)
        supportActionBar!!.setDisplayShowHomeEnabled(true);
    supportActionBar!!.setDisplayHomeAsUpEnabled(true);
}
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}