package com.example.smarthome.presentation.home

import com.example.smarthome.domain.GetRoomListUseCase
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class HomePresenter @Inject constructor(
    private val getRoomListUseCase: GetRoomListUseCase
) :MvpPresenter<HomeView>() {

    init {
        Single.just("")
            .observeOn(Schedulers.io())
            .subscribe({
                getRoomListUseCase()
            },{ })
    }

}