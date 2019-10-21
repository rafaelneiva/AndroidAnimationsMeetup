package com.rafaelneiva.androidanimations.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.rafaelneiva.androidanimations.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        viewPager.offscreenPageLimit = 3

//        viewPager.setPageTransformer(false) { page, position ->
//
//            // Zoom
//            val minScale = 0.1f
//            val scaleFactor = minScale + (1 - minScale) * (1 - Math.abs(position))
//            page.pivotY = 0.5f * page.height
//            page.pivotX = 0.5f * page.width
//            page.scaleX = scaleFactor
//            page.scaleY = scaleFactor
//
//            // Cube
////            page.pivotX = if (position < 0f) page.width.toFloat() else 0f
////            page.pivotY = page.width * 0.5f
////            page.rotationY = 45f * position
//
//            // Rotation
////            val rotation = 180f * position
////            page.alpha = if(rotation > 90f || rotation < -90f) 0f else 1f
////            page.pivotX = if (position < 0f) page.width.toFloat() else 0f
////            page.pivotY = page.width * 0.5f
////            page.rotationY = rotation
//        }
    }
}