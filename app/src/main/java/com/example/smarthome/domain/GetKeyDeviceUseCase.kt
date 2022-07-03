package com.example.smarthome.domain

import javax.inject.Inject

class GetKeyDeviceUseCase @Inject constructor(
    private val repository: SmartHomeRepository
) {
    fun invoke(uuid: String) = repository.getKeyDevice(uuid)
}