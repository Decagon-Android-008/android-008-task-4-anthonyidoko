package com.example.weekfourtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.helloui2.MyRecyclerViewAdapter
import com.example.helloui2.RecyclerData
import com.example.myweekfourtask.MyViewPagerAdapter
import com.example.myweekfourtask.ViewPagerData
import java.lang.Math.abs

class MainActivity : AppCompatActivity() {
    lateinit var myImageList :Array<Int>
    lateinit var myRecyclerViewAdapter: RecyclerView
    lateinit var myViewPagerAdapter: ViewPager2
    lateinit var firstText :Array<String>
    lateinit var myObjectList: ArrayList<RecyclerData>
    lateinit var nameText: Array<String>
    lateinit var itemList: ArrayList<ViewPagerData>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerViewAdapter = findViewById(R.id.recyclerView)
        myViewPagerAdapter = findViewById(R.id.viewPager)



//        myImageList = arrayOf(
//
//            R.drawable.jonathan_background,R.drawable.jonathan_background,
//            R.drawable.jonathan_background,R.drawable.jonathan_background,
//            R.drawable.jonathan_background,R.drawable.jonathan_background,
//            R.drawable.jonathan_background,R.drawable.jonathan_background
//
//        )


        // Birthday Celebrants Array
        firstText = arrayOf(

            "Oseiwe Ehiremhen","Samuel Ochuba", "Okezie Joseph","Tolulope Longe","Godday Okoduwa",
            "Anthony Idoko","Abbas Adisa", "Abdulrasheed Ilori","Emmanuel O","Daniel Okon",
            "Johnson Oyesina","Victor Bamikole","Chiazam Ochiegbu","Peter Akam","Samuel Ungbede",
        )

        // Names of Celebrants Array
        nameText = arrayOf(

            "Osehi","Samuel","Okezie","Tolu","Godday","Anthony","Abbas",
            "Ilori","Emmanuel","Victor","Johnson","Victor","Chiazam","Peter",
            "Samuel",
        )


        // Add data to the myObjectList ArrayList declared up
        myObjectList = ArrayList()
        fillMyRecyclerViewArrayList()

        //Define layout manager for the adapter
        myRecyclerViewAdapter.layoutManager = LinearLayoutManager(this)

        //Pass the myObject arraylist in the adapter
        myRecyclerViewAdapter.adapter = MyRecyclerViewAdapter(myObjectList)

        myRecyclerViewAdapter.isNestedScrollingEnabled = false

        //Fill itemList arraylist with items
        itemList = ArrayList()
        fillMyViewPAgerArrayList()




        val adapter = MyViewPagerAdapter(itemList)

        myViewPagerAdapter.adapter = adapter
        myViewPagerAdapter.clipToPadding = false
        myViewPagerAdapter.clipChildren = false
        myViewPagerAdapter.offscreenPageLimit = 3

        //Set padding on the adapter
        myViewPagerAdapter.setPadding(10,10,150,10)


        //Define transformation for the adapter
        val setTransformation = CompositePageTransformer()
        setTransformation.addTransformer{ page,position ->
            val space:Float = 1 - kotlin.math.abs(position)
            page.translationX = 60f
            page.scaleY = 0.85f + space * 0.15f
        }

        //Set transformation on adapter
        myViewPagerAdapter.setPageTransformer(setTransformation)

    }


    //A function that creates the object from RecyclerData class and adds the object to the arraylist
    fun fillMyRecyclerViewArrayList(){
        for (i in firstText.indices){
            val item = RecyclerData(R.drawable.jonathan_background,firstText[i],"10.10.2020","10days left")
            myObjectList.add(item)
        }
    }


    //A function that creates object from ViewPAgerData class and adds the object to the itemList arraylist
    fun fillMyViewPAgerArrayList(){
        for (i in firstText.indices){
            val item = ViewPagerData(R.drawable.jonathan_background,"It's ${nameText[i]}'s birthday",R.drawable.ic_flower)
            itemList.add(item)

        }
    }
}