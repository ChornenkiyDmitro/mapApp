package com.example.shavyha_map.presentation.main.places.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.shavyha_map.data_source.database.entity.PlacesEntity
import kotlinx.android.synthetic.main.list_item.view.*

open class ListViewHolder
    (itemView: View,
     private val listenerItem: ListItemListener
) : RecyclerView.ViewHolder(itemView){

    fun bind(place: PlacesEntity){
        with(itemView){
            textPlaceName.text = place.placeName
            textCountry.text = place.country
            textCity.text = place.city
            textStreet.text = place.street

            setOnClickListener {
                listenerItem.onPlaceClick(place)
            }
        }
    }

}