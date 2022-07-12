package com.example.smarthome.presentation.home

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface HomeView: MvpView {

    @AddToEndSingle
    fun setRoomList()
}