package com.example.smarthome.data.database

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import org.bson.types.ObjectId


open class RoomItemDb(
    @PrimaryKey
    var id: Int = 0,
    var name: String = "",
    var image: Int = 0,
    var countOfDevices: Int = 0
) : RealmObject()