package com.example.smarthome.presentation.addroom.adapter

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import com.example.smarthome.domain.RoomType

object RoomItemCallback: DiffUtil.ItemCallback<RoomType>() {
    override fun areItemsTheSame(oldItem: RoomType, newItem: RoomType): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RoomType, newItem: RoomType): Boolean {
        return oldItem== newItem
    }
}