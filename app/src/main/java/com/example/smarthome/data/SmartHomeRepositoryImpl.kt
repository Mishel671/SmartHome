package com.example.smarthome.data

import android.util.Log
import com.example.smarthome.data.database.RoomItemDb
import com.example.smarthome.domain.RoomItem
import com.example.smarthome.domain.RoomType
import com.example.smarthome.domain.SmartHomeRepository
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Inject

class SmartHomeRepositoryImpl @Inject constructor(
    private val roomTypeInflate: RoomTypeInflate,
    private val realmConfig: RealmConfiguration
) : SmartHomeRepository {

    override fun getRoomTypeList(): List<RoomType> {
        return roomTypeInflate.getRoomTypeList()
    }

    override fun insertRoom(roomItem: RoomItem) {
        val realm = Realm.getInstance(realmConfig)
        realm.apply {
            beginTransaction()
            insert(roomItem.mapToRoomItemDb())
            commitTransaction()
        }
    }

    override fun getRoomList() {
        val realm = Realm.getInstance(realmConfig)
        realm.beginTransaction()
        val result = realm
            .where(RoomItemDb::class.java)
            .findAll()
            .map {
                it.mapToRoomItem()
            }
        realm.commitTransaction()

        Log.d("SmartHomeRepositoryImpl", "Result: $result")
    }
}