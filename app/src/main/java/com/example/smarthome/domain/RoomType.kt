package com.example.smarthome.domain

import androidx.annotation.DrawableRes

data class RoomType(
    val id: Int,
    val name: String,
    var enabled: Boolean,
    @DrawableRes val imageId: Int
)