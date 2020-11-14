package com.example.onlinebus

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.AsyncTask
import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlinebus.adapter.GridViewAdapter
import com.example.onlinebus.adapter.ImageAdapter
import com.example.onlinebus.entity.BusWithPlaces
import com.example.onlinebus.entity.ImageId
import com.example.onlinebus.entity.Place
import com.example.onlinebus.entity.TripWithBus
import com.example.onlinebus.room.AppDatabase
import kotlinx.android.synthetic.main.activity_booking_place.*
import kotlinx.android.synthetic.main.seat_item.view.*
import kotlinx.android.synthetic.main.trip_item.view.*


class BookingPlaceActivity : AppCompatActivity() {
   lateinit var gridView: GridView
   lateinit var secondGridView: GridView
   lateinit var thirdGridView: GridView
   lateinit var lastGridView: GridView


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_place)

        var firstColumnList = ArrayList<Place>()
        var secondColumnList = ArrayList<Place>()
        var thirdColumnList = ArrayList<Place>()
        var lastColumnList = ArrayList<Place>()

        val busId: Long = intent.getLongExtra(TripActivity.BUS_ID, 0)
        val tripId: Long = intent.getLongExtra(TripActivity.TRIP_ID, 0)
        toolbarSettings()
        AsyncTask.execute {
            val busWithPlaces = AppDatabase.getInstance(applicationContext)?.getBusDao()?.getBusWithPlacesByBusId(busId)
            val tripWithBus = AppDatabase.getInstance(applicationContext)?.getTripDao()?.getTripWithBus(tripId)

            runOnUiThread {

                tripWithBus?.let { fillTripInfo(busWithPlaces = busWithPlaces, tripWithBus = it) }

                for (i in busWithPlaces?.placeList!!){
                    if (i.placeNum  <= 20){
                        firstColumnList.add(i)
                    }else if (i.placeNum in 21..32){
                        secondColumnList.add(i)
                    }else if (i.placeNum in 33..36 || i.placeNum in 38..39){
                        thirdColumnList.add(i)
                    }else{
                        lastColumnList.add(i)
                    }
                }

                gridView = findViewById(R.id.first_column)
                secondGridView = findViewById(R.id.second_column)
                thirdGridView = findViewById(R.id.third_column)
                lastGridView = findViewById(R.id.last_grid_view)

                gridView.setOnItemClickListener { parent, view, position, id ->
                   if (firstColumnList[position].status){
                       view.seat_item_bg.setBackgroundResource(R.drawable.selected_seat_place_bg)
                       view.seat_place_price.setTextColor(Color.WHITE)
                       view.seat_place_num.setTextColor(Color.WHITE)
                   }
                }
                secondGridView.setOnItemClickListener { parent, view, position, id ->
                    if (secondColumnList[position].status){
                        view.seat_item_bg.setBackgroundResource(R.drawable.selected_seat_place_bg)
                        view.seat_place_price.setTextColor(Color.WHITE)
                        view.seat_place_num.setTextColor(Color.WHITE)
                    }
                }
                thirdGridView.setOnItemClickListener { parent, view, position, id ->
                    if (thirdColumnList[position].status){
                        view.seat_item_bg.setBackgroundResource(R.drawable.selected_seat_place_bg)
                        view.seat_place_price.setTextColor(Color.WHITE)
                        view.seat_place_num.setTextColor(Color.WHITE)
                    }
                }
                lastGridView.setOnItemClickListener { parent, view, position, id ->
                    if (thirdColumnList[position].status){
                        view.seat_item_bg.setBackgroundResource(R.drawable.selected_seat_place_bg)
                        view.seat_place_price.setTextColor(Color.WHITE)
                        view.seat_place_num.setTextColor(Color.WHITE)
                    }
                }

                var adapter = GridViewAdapter(this, firstColumnList)
                gridView.adapter = adapter
                var adapter2 = GridViewAdapter(this, secondColumnList)
                secondGridView.adapter = adapter2
                var adapter3 = GridViewAdapter(this, thirdColumnList)
                thirdGridView.adapter = adapter3
                var adapter4 = GridViewAdapter(this, lastColumnList)
                lastGridView.adapter = adapter4
            }
        }


    }

    @SuppressLint("SetTextI18n")
    private fun fillTripInfo(tripWithBus: TripWithBus, busWithPlaces: BusWithPlaces?){
        val imageList = mutableListOf(
            ImageId(id = R.drawable.busimg),
            ImageId(id = R.drawable.img2),
            ImageId(id = R.drawable.img1)
        )

        val mLayoutManager = LinearLayoutManager(this)
        mLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        image_item_recycler_view.layoutManager = mLayoutManager
        image_item_recycler_view.itemAnimator = DefaultItemAnimator()
        image_item_recycler_view.adapter = ImageAdapter(imageList = imageList)

        from_city_item.text = tripWithBus.trip.fromCity
        to_city_item.text = tripWithBus.trip.toCity
        departure_day_lable_item.text = tripWithBus.trip.depDay
        arrive_day_lable_item.text = tripWithBus.trip.arrDay
        if (tripWithBus.trip.depMinute <= 9) {
            departure_time_lable_item.text =
                "${tripWithBus.trip.depHour}:0${tripWithBus.trip.depMinute}"
        }else{
            departure_time_lable_item.text =
                "${tripWithBus.trip.depHour}:${tripWithBus.trip.depMinute}"
        }
        if (tripWithBus.trip.arrMinute <= 9) {
            arrive_time_lable_item.text = "${tripWithBus.trip.arrHour}:0${tripWithBus.trip.arrMinute}"
        }else{
            arrive_time_lable_item.text = "${tripWithBus.trip.arrHour}:${tripWithBus.trip.arrMinute}"
        }
        duration_time_hours_item.text = "${tripWithBus.bus.tripDuration} часа"
        bus_model_item.text = tripWithBus.bus.busModel
        bus_gos_nomer_item.text = tripWithBus.bus.stateLicensePlate
        bus_release_year_item.text = tripWithBus.bus.releaseYear
        average_price.text = "От ${tripWithBus.bus.averagePrice} т"
        ferryman_label.text = busWithPlaces?.bus?.ferryman
        admin_label.text = busWithPlaces?.bus?.admin
        phone_1_label.text = busWithPlaces?.bus?.phone1
        phone_2_label.text = busWithPlaces?.bus?.phone2

        val freePlaceList = ArrayList<Place>()
        total_place_num_item.text = "${busWithPlaces?.placeList?.count()}"
        for (free in busWithPlaces?.placeList!!){
            if (free.status){
                freePlaceList.add(free)
            }
        }
        left_place_num_item.text = "${freePlaceList.count()}"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun toolbarSettings(){
        supportActionBar!!.title = getString(R.string.booking_label)
        supportActionBar!!.setDisplayShowHomeEnabled(true);
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);
    }

}