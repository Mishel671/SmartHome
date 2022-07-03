package com.example.smarthome.data

import com.example.smarthome.domain.KeyDevice
import com.example.smarthome.domain.SmartHomeRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class SmartHomeRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : SmartHomeRepository {

    override fun getKeyDevice(uuid: String): Single<KeyDevice> {
        return apiService.getKeyDevice(uuid)
            .observeOn(Schedulers.io())
            .map { it.mapToEntity() }
            .subscribeOn(AndroidSchedulers.mainThread())
    }
}