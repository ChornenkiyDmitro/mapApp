package com.example.shavyha_map.presentation.detail

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.shavyha_map.R
import com.example.shavyha_map.presentation.base.BaseActivity
import com.example.shavyha_map.view_model.DetailViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : BaseActivity(), OnMapReadyCallback {

    private var placesMap: GoogleMap? = null

    private val detailViewModel: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapDetail) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val placeId = intent.getIntExtra("place", -1)
        if (placeId != -1) {
            detailViewModel?.getPlaceById(placeId)
        }

        setupViewModel()
    }

    private fun setupViewModel() {
        detailViewModel?.placeGetById?.observe(this, Observer { place ->


            placesMap?.addMarker(
                MarkerOptions()
                    .position(LatLng(place.latitude, place.longitude))
                    .title(place.placeName)
            )

            placesMap?.moveCamera(
                CameraUpdateFactory.newLatLng(
                    LatLng(
                        place.latitude,
                        place.longitude
                    )
                )
            )
            placesMap?.setMinZoomPreference(16.0f)

            textLatitude.text = place.latitude.toString()
            textLongitude.text = place.longitude.toString()
            textCountry.text = place.country
            textCity.text = place.city
            textStreet.text = place.street
        }
        )
    }

    override fun onMapReady(googleMap: GoogleMap) {
        placesMap = googleMap
    }
}


