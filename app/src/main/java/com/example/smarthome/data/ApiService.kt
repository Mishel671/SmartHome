package com.example.smarthome.data


import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface ApiService {

    @PATCH("mobile")
    fun getKeyDevice(@Query("uuid") uuid: String): Single<KeyDeviceDto>
}