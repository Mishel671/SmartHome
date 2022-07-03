package com.example.smarthome.domain

import io.reactivex.rxjava3.core.Single

interface SmartHomeRepository {

    fun getKeyDevice(uuid: String): Single<KeyDevice>

}