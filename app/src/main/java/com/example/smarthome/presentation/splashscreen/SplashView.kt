package com.example.smarthome.presentation.splashscreen

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface SplashView: MvpView {

    @AddToEndSingle
    fun launchNextScreen()
}