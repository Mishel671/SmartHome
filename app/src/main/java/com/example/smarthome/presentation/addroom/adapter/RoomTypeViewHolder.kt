package com.example.smarthome.presentation.addroom.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.smarthome.databinding.RoomTypeItemDisableBinding
import com.example.smarthome.databinding.RoomTypeItemEnableBinding

sealed class RoomTypeViewHolder(
    binding: ViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    class ItemEnableViewHolder(val binding: RoomTypeItemEnableBinding) :
        RoomTypeViewHolder(binding) {

        }

    class ItemDisableViewHolder(val binding: RoomTypeItemDisableBinding) :
        RoomTypeViewHolder(binding) {

        }
}