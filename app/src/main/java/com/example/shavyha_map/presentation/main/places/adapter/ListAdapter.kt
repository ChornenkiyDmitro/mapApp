package com.example.shavyha_map.presentation.main.places.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shavyha_map.R
import com.example.shavyha_map.data_source.database.entity.PlacesEntity

class ListAdapter(private val listener: ListItemListener): RecyclerView.Adapter<ListViewHolder>() {

    private var placeList = mutableListOf<PlacesEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false),
            listener
        )
    }

    override fun getItemCount(): Int {
      return placeList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
       holder.bind(placeList[position])
    }

    fun setData(place: List<PlacesEntity>) {
        Log.d("ListAdapter", "users = $place")
        placeList.clear()
        placeList.addAll(place)
        notifyDataSetChanged()
    }
}

