package com.example.onlinebus.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.os.AsyncTask
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinebus.R
import com.example.onlinebus.entity.ImageId
import com.example.onlinebus.entity.Place
import com.example.onlinebus.entity.TripWithBus
import com.example.onlinebus.room.AppDatabase
import kotlinx.android.synthetic.main.activity_booking_place.*
import kotlinx.android.synthetic.main.trip_item.view.*

class TripListAdapter(
    private val itemList: List<TripWithBus> = listOf(),
    private val onTripClick:(TripWithBus) -> Unit,
    private val currentActivity:Activity
) : RecyclerView.Adapter<TripListAdapter.HintViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HintViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.trip_item, parent, false)
        return HintViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    override fun onBindViewHolder(holder: HintViewHolder, position: Int) {
        holder.bindHint(itemList[position])
    }


    inner class HintViewHolder(
        private val view: View
    ):RecyclerView.ViewHolder(view){
        @SuppressLint("SetTextI18n")
        fun bindHint(tripWithBus: TripWithBus){

            val imageList = mutableListOf(
                ImageId(id = R.drawable.img1),
                ImageId(id = R.drawable.img2),
                ImageId(id = R.drawable.busimg)
            )


            AsyncTask.execute{
                val busWithPlace = tripWithBus.bus.busId?.let {
                    AppDatabase.getInstance(currentActivity.applicationContext)
                        ?.getBusDao()?.getBusWithPlacesByBusId(it)
                }

                currentActivity.runOnUiThread{
                    val freePlaceList = ArrayList<Place>()
                    view.total_place_num.text = "${busWithPlace?.placeList?.count()}"
                    for (free in busWithPlace?.placeList!!){
                        if (free.status){
                            freePlaceList.add(free)
                        }
                    }
                    view.left_place_num.text = "${freePlaceList.count()}"

                }

            }

            val mLayoutManager = LinearLayoutManager(currentActivity.applicationContext)
            mLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
            view.image_recycler_view.layoutManager = mLayoutManager
            view.image_recycler_view.itemAnimator = DefaultItemAnimator()
            view.image_recycler_view.adapter = ImageAdapter(imageList = imageList)

            view.from_city.text = tripWithBus.trip.fromCity
            view.to_city.text = tripWithBus.trip.toCity
            view.departure_day_lable.text = tripWithBus.trip.depDay
            view.arrive_day_lable.text = tripWithBus.trip.arrDay
            if (tripWithBus.trip.depMinute <= 9) {
                view.departure_time_lable.text =
                    "${tripWithBus.trip.depHour}:0${tripWithBus.trip.depMinute}"
            }else{
                view.departure_time_lable.text =
                    "${tripWithBus.trip.depHour}:${tripWithBus.trip.depMinute}"
            }
            if (tripWithBus.trip.arrMinute <= 9) {
                view.arrive_time_lable.text = "${tripWithBus.trip.arrHour}:0${tripWithBus.trip.arrMinute}"
            }else{
                view.arrive_time_lable.text = "${tripWithBus.trip.arrHour}:${tripWithBus.trip.arrMinute}"
            }
            view.duration_time_hours.text = "${tripWithBus.bus.tripDuration} часа"
            view.bus_model.text = tripWithBus.bus.busModel
            view.bus_gos_nomer.text = tripWithBus.bus.stateLicensePlate
            view.bus_release_year.text = tripWithBus.bus.releaseYear
            view.average_price.text = "От ${tripWithBus.bus.averagePrice} т"
               view.setOnClickListener {
                   onTripClick(tripWithBus)
               }
        }
    }
}