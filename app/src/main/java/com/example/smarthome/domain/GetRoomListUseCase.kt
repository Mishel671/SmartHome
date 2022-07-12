package com.example.smarthome.domain

import javax.inject.Inject

class GetRoomListUseCase @Inject constructor(
    private val repository: SmartHomeRepository
) {
    operator fun invoke() = repository.getRoomList()
}