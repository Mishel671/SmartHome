package com.example.smarthome.data

import com.google.gson.annotations.SerializedName

data class KeyDeviceDto(
    @SerializedName("keyDevice")
    val keyDevice: String?
)