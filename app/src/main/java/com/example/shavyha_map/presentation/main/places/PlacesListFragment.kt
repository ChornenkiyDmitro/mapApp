package com.example.shavyha_map.presentation.main.places

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shavyha_map.R
import com.example.shavyha_map.data_source.database.entity.PlacesEntity
import com.example.shavyha_map.presentation.detail.DetailActivity
import com.example.shavyha_map.presentation.main.places.adapter.ListAdapter
import com.example.shavyha_map.presentation.main.places.adapter.ListItemListener
import com.example.shavyha_map.view_model.MainViewModel
import kotlinx.android.synthetic.main.fragment_places_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlacesListFragment : Fragment(), ListItemListener {

    companion object {
        fun newInstance() = PlacesListFragment()
    }

    val adapter = ListAdapter(this)

    val mainViewModel : MainViewModel? by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_places_list, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rwPlacesList.adapter = adapter
        rwPlacesList.layoutManager = LinearLayoutManager(context)

        mainViewModel?.getAllPlaces()
        mainViewModel?.allPlaces?.observe(viewLifecycleOwner, Observer<List<PlacesEntity>>{
            adapter.setData(it)
        })

    }

    override fun onPlaceClick(place: PlacesEntity) {
        val intent  = Intent (activity, DetailActivity::class.java)
        intent.putExtra("place", place.id)
        startActivity(intent)
    }
}
