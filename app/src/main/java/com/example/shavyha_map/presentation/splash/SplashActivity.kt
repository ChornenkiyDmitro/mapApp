package com.example.shavyha_map.presentation.splash

import android.content.Intent
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.os.Handler

import com.example.shavyha_map.R
import com.example.shavyha_map.data_source.database.entity.PlacesEntity
import com.example.shavyha_map.presentation.base.BaseActivity
import com.example.shavyha_map.presentation.main.MainActivity
import com.example.shavyha_map.view_model.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity() {

    private val splashViewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)

            splashViewModel.deleteTable()
            insertDataToDataBase()

            startActivity(intent)
            finish()
        }, 10000)

    }



    private fun insertDataToDataBase() {
        addTopShavyha()
        addHansik()
        addPlaneta()
        addDonerKing()
        addEDa()
    }

    private fun getAddress(lat: Double, lng: Double): Address? {
        val listAddress: List<Address> = Geocoder(this).getFromLocation(
                lat, lng, 1
        )
        return if (listAddress.isNotEmpty()) listAddress[0] else null
    }


    private fun addTopShavyha(){
        val lat = 48.4502601
        val lng = 35.0573791
        val address = getAddress(lat,lng)
        val place = PlacesEntity(
                1,
                "Top Shavyha",
                address?.countryName ?: "",
                address?.locality ?: "",
                address?.thoroughfare?: "",
                lat,
                lng
        )
        splashViewModel?.insertPlace(place)
    }

    private fun addHansik(){
        val lat = 48.4586711
        val lng = 35.0555804
        val address = getAddress(lat,lng)
        val place = PlacesEntity(
                2,
                "Hansik",
                address?.countryName ?: "",
                address?.locality ?: "",
                address?.thoroughfare ?: "",
                lat,
                lng
        )
        splashViewModel?.insertPlace(place)
    }

    private fun addPlaneta(){
        val lat = 48.4585604
        val lng = 35.0613234
        val address = getAddress(lat,lng)
        val place = PlacesEntity(
                3,
                "Planeta",
                address?.countryName ?: "",
                address?.locality ?: "",
                address?.thoroughfare ?: "",
                lat,
                lng
        )
        splashViewModel?.insertPlace(place)
    }

    private fun addDonerKing(){
        val lat = 48.4564584
        val lng = 35.0615111
        val address = getAddress(lat,lng)
        val place = PlacesEntity(
                4,
                "Doner King",
                address?.countryName ?: "",
                address?.locality ?: "",
                address?.thoroughfare ?: "",
                lat,
                lng
        )
        splashViewModel?.insertPlace(place)
    }

    private fun addEDa(){
        val lat = 48.4539151
        val lng = 35.0639528
        val address = getAddress(lat,lng)
        val place = PlacesEntity(
                5,
                "e.Da",
                address?.countryName ?: "",
                address?.locality ?: "",
                address?.thoroughfare ?: "",
                lat,
                lng
        )
        splashViewModel?.insertPlace(place)
    }
}