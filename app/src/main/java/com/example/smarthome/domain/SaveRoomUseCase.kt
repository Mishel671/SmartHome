package com.example.smarthome.domain

import javax.inject.Inject

class SaveRoomUseCase @Inject constructor(
    private val repository: SmartHomeRepository
) {
    operator fun invoke(roomItem: RoomItem) = repository.insertRoom(roomItem)
}