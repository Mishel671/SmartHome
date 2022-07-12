package com.example.smarthome.presentation.addroom

import com.example.smarthome.domain.RoomType
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface AddRoomView: MvpView {

    @AddToEndSingle
    fun setRoomTypeList(roomTypeList: List<RoomType>)

}