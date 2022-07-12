package com.example.smarthome.domain


interface SmartHomeRepository {

    fun getRoomTypeList(): List<RoomType>

    fun insertRoom(roomItem: RoomItem)

    fun getRoomList()
}