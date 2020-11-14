package com.example.onlinebus.ui.home

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.onlinebus.TripActivity
import com.example.onlinebus.R
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.util.*


class HomeFragment : Fragment(R.layout.fragment_home) {

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "OnlineBus"

        val btnCalendar = view.findViewById<Button>(R.id.calendar_btn)
        val btnSearch = view.findViewById<Button>(R.id.search_btn)

        btnCalendar.setOnClickListener {
            datePickerDialog(view)
        }
        btnSearch.setOnClickListener {
            val intent = Intent(activity, TripActivity::class.java)
            startActivity(intent)
        }

        super.onViewCreated(view, savedInstanceState)
    }

    @SuppressLint("SetTextI18n")
    private fun datePickerDialog(rootView: View){
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        rootView.context?.let {
            DatePickerDialog(it, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                rootView.calendar_btn.text = "${dayOfMonth}.${month}.${year}"
            },year, month, day)
        }?.show()
    }
}