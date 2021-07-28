package com.example.helloui2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weekfourtask.R

class MyRecyclerViewAdapter(val myList: ArrayList<RecyclerData>): RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>(){

    class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
        var first_card_text :TextView
        var card_second_text: TextView
        var card_first_text: TextView
        var shapeAbleImageView: androidx.constraintlayout.widget.ConstraintLayout

        init {
            first_card_text = view.findViewById(R.id.first_card_text)
            card_second_text = view.findViewById(R.id.card_second_text)
            card_first_text = view.findViewById(R.id.card_first_text)
            shapeAbleImageView = view.findViewById(R.id.shapeAbleImageViewConstraint)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_recycler_view_items,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = myList[position]
        holder.shapeAbleImageView.setBackgroundResource(currentItem.imageView)
        holder.first_card_text.text  = currentItem.firstText
        holder.card_second_text.text = currentItem.secondText
        holder.card_first_text.text = currentItem.thirdText
    }

    override fun getItemCount(): Int {
        return myList.size
    }

}