package com.example.shavyha_map.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shavyha_map.R
import com.example.shavyha_map.presentation.main.adapter.MainViewPagerAdapter
import com.example.shavyha_map.presentation.main.main_map.MainMapFragment
import com.example.shavyha_map.presentation.main.places.PlacesListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MainViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(MainMapFragment.newInstance(), "Map")
        adapter.addFragment(PlacesListFragment.newInstance(), "List")

        caseFragment.adapter = adapter
        tabsMain.setupWithViewPager(caseFragment)
    }
}
