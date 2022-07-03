package com.example.smarthome.presentation.splashscreen

import android.util.Log
import com.example.smarthome.domain.GetKeyDeviceUseCase
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject


@InjectViewState
class SplashPresenter @Inject constructor(
    private val getKeyDeviceUseCase: GetKeyDeviceUseCase
) : MvpPresenter<SplashView>() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()


    fun registration(uuid: String) {
        val dispose = getKeyDeviceUseCase.invoke(uuid)
            .subscribe({
                Log.d("SplashPresenter", it.keyDevice)
            }, {

            })
        compositeDisposable.add(dispose)
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }
}