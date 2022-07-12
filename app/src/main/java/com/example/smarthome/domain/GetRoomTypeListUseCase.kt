package com.example.smarthome.domain

import javax.inject.Inject

class GetRoomTypeListUseCase @Inject constructor(
    private val repository: SmartHomeRepository
){
    operator fun invoke() = repository.getRoomTypeList()
}