package com.example.myweekfourtask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weekfourtask.R

class MyViewPagerAdapter(var itemList: ArrayList<ViewPagerData>): RecyclerView.Adapter<MyViewPagerAdapter.ViewHolder>(){

    inner class ViewHolder(view :View): RecyclerView.ViewHolder(view){

        var viewPagerImage: ImageView = view.findViewById(R.id.viewPagerImage)
        var nameText: TextView = view.findViewById(R.id.nameText)
        var specialImage :ImageView = view.findViewById(R.id.specialImage)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.my_view_pager_items,parent,false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.viewPagerImage.setImageResource(currentItem.viewPagerImage)
        holder.nameText.text  = currentItem.nameText
        holder.specialImage.setImageResource(currentItem.specialImage)

    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}