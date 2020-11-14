package com.example.onlinebus.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.onlinebus.R
import com.example.onlinebus.entity.Place
import kotlinx.android.synthetic.main.seat_item.view.*

class GridViewAdapter(
    var context:Context,
    var placeList: List<Place>
): BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null
    @SuppressLint("InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View
        if (layoutInflater == null){
            layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertView == null){
            view = layoutInflater!!.inflate(R.layout.seat_item, null)
        }else{
            view = convertView
        }

        var textView = view.findViewById<TextView>(R.id.seat_place_num)
        var textViewPrice = view.findViewById<TextView>(R.id.seat_place_price)
        textView?.text = placeList[position].placeNum.toString()
        textViewPrice?.text = placeList[position].placePrice.toString()

        if (!placeList[position].status){
            view.seat_item_bg.setBackgroundResource(R.drawable.booked_seat_place_bg)
            view.seat_place_price.text = ""
        }

        return view
    }

    override fun getItem(position: Int): Any {
        return placeList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return placeList.count()
    }
}