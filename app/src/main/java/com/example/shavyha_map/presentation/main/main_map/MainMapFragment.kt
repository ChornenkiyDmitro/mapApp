package com.example.shavyha_map.presentation.main.main_map


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.shavyha_map.R
import com.example.shavyha_map.data_source.database.entity.PlacesEntity
import com.example.shavyha_map.view_model.MainViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainMapFragment : Fragment(), OnMapReadyCallback {

    private var placesMap: GoogleMap? = null

    val mainViewModel : MainViewModel? by viewModel()

    companion object {
        var mapFragment : SupportMapFragment?=null
        val TAG: String = MainMapFragment::class.java.simpleName
        fun newInstance() = MainMapFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_main_map, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapFragment = childFragmentManager.findFragmentById(R.id.mapMain) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

        mainViewModel?.getAllPlaces()
        mainViewModel?.allPlaces?.observe(viewLifecycleOwner, Observer<List<PlacesEntity>> { list ->
            if (list.isNotEmpty()) {
                list.forEach { place -> drawPin(place) }
                placesMap?.moveCamera(
                    CameraUpdateFactory.newLatLng(
                        LatLng(
                            list.first().latitude,
                            list.first().longitude
                        )
                    )
                )

                placesMap?.setMinZoomPreference(14.0f)
            }
        })
    }

    override fun onMapReady(googleMap: GoogleMap) {
        placesMap = googleMap
    }

    private fun drawPin(place: PlacesEntity) {
        placesMap?.addMarker(
            MarkerOptions()
                .position(LatLng(place.latitude, place.longitude))
                .title(place.placeName)
        )
    }
}