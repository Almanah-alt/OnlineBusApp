package com.example.onlinebus.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinebus.R
import com.example.onlinebus.entity.ImageId
import kotlinx.android.synthetic.main.image_item.view.*

class ImageAdapter(
    private val imageList: List<ImageId>
):RecyclerView.Adapter<ImageAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.count()
    }

    override fun onBindViewHolder(holder: ImageAdapter.MyViewHolder, position: Int) {
        holder.bindItem(imageList[position])
    }
    inner class MyViewHolder(
        private val view: View
    ):RecyclerView.ViewHolder(view){
        fun bindItem(imageId: ImageId){
            view.image_item.setImageResource(imageId.id)
        }
    }
}