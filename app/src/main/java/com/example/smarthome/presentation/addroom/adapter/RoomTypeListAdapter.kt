package com.example.smarthome.presentation.addroom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.smarthome.databinding.RoomTypeItemDisableBinding
import com.example.smarthome.databinding.RoomTypeItemEnableBinding
import com.example.smarthome.domain.RoomType

class RoomTypeListAdapter : ListAdapter<RoomType, RoomTypeViewHolder>(RoomItemCallback) {

    var onRoomItemClickListener: ((RoomType) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomTypeViewHolder {
        return when (viewType) {
            VIEW_TYPE_ENABLED -> {
                RoomTypeViewHolder.ItemEnableViewHolder(
                    RoomTypeItemEnableBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            VIEW_TYPE_DISABLED -> {
                RoomTypeViewHolder.ItemDisableViewHolder(
                    RoomTypeItemDisableBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
    }


    override fun onBindViewHolder(holder: RoomTypeViewHolder, position: Int) {
        val item = getItem(position)
        when(holder){
            is RoomTypeViewHolder.ItemEnableViewHolder -> {
                val binding = holder.binding
                binding.itemImage.setImageResource(item.imageId)
                binding.itemName.text = item.name
                binding.root.setOnClickListener{
                    onRoomItemClickListener?.invoke(item)
                }
            }
            is RoomTypeViewHolder.ItemDisableViewHolder -> {
                val binding = holder.binding
                binding.itemImage.setImageResource(item.imageId)
                binding.itemName.text = item.name
                binding.root.setOnClickListener{
                    onRoomItemClickListener?.invoke(item)
                }
            }
        }
    }


    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.enabled) {
            VIEW_TYPE_ENABLED
        } else {
            VIEW_TYPE_DISABLED
        }
    }

    companion object {

        const val VIEW_TYPE_ENABLED = 100
        const val VIEW_TYPE_DISABLED = 101
        const val MAX_POOL_SIZE = 15
    }
}