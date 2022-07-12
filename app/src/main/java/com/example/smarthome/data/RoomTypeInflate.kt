package com.example.smarthome.data

import android.content.Context
import androidx.annotation.StringRes
import com.example.smarthome.R
import com.example.smarthome.domain.RoomType
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomTypeInflate @Inject constructor(
    @ApplicationContext private val appContext: Context
) {

    fun getRoomTypeList(): List<RoomType> {
        return listOf(
            RoomType(
                id = 0,
                name = getString(R.string.kitchen_item_title),
                imageId = R.drawable.ic_kitchen,
                enabled = false
            ),
            RoomType(
                id = 1,
                name = getString(R.string.bedroom_item_title),
                imageId = R.drawable.ic_bedroom,
                enabled = false
            ),
            RoomType(
                id = 2,
                name = getString(R.string.bathroom_item_title),
                imageId = R.drawable.ic_bathroom,
                enabled = false
            ),
            RoomType(
                id = 3,
                name = getString(R.string.office_item_title),
                imageId = R.drawable.ic_office,
                enabled = false
            ),
            RoomType(
                id = 4,
                name = getString(R.string.tv_room_item_title),
                imageId = R.drawable.ic_tv_room,
                enabled = false
            ),
            RoomType(
                id = 5,
                name = getString(R.string.living_room_item_title),
                imageId = R.drawable.ic_living_room,
                enabled = false
            ),
            RoomType(
                id = 6,
                name = getString(R.string.garage_item_title),
                imageId = R.drawable.ic_garage,
                enabled = false
            ),
            RoomType(
                id = 7,
                name = getString(R.string.toilet_item_title),
                imageId = R.drawable.ic_toilet,
                enabled = false
            ),
            RoomType(
                id = 8,
                name = getString(R.string.kid_room_item_title),
                imageId = R.drawable.ic_kid_room,
                enabled = false
            )

        )
    }

    private fun getString(@StringRes string: Int): String {
        return appContext.getString(string)
    }

}