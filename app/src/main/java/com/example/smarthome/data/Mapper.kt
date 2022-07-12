package com.example.smarthome.data

import com.example.smarthome.data.database.RoomItemDb
import com.example.smarthome.domain.RoomItem

fun RoomItem.mapToRoomItemDb(): RoomItemDb {
    val item = this
    return RoomItemDb().apply {
        id = 0
        name = item.name
        image = item.image
        countOfDevices = item.countOfDevices
    }
}

fun RoomItemDb.mapToRoomItem() = RoomItem(
    name = this.name,
    image = this.image,
    countOfDevices = this.countOfDevices
)