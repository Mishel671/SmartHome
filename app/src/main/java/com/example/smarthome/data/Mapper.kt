package com.example.smarthome.data

import com.example.smarthome.domain.KeyDevice

fun KeyDeviceDto.mapToEntity(): KeyDevice {
    return KeyDevice(
        keyDevice = this.keyDevice ?: ""
    )
}