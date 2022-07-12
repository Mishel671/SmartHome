package com.example.smarthome.presentation.addroom


import com.example.smarthome.domain.GetRoomTypeListUseCase
import com.example.smarthome.domain.RoomItem
import com.example.smarthome.domain.RoomType
import com.example.smarthome.domain.SaveRoomUseCase
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class AddRoomPresenter @Inject constructor(
    private val getRoomTypeListUseCase: GetRoomTypeListUseCase,
    private val saveRoomUseCase: SaveRoomUseCase
) : MvpPresenter<AddRoomView>() {

    private val roomTypeList = getRoomTypeListUseCase()

    private var chooseRoomType: RoomType? = null

    init {
        initRoomList()
    }

    fun saveRoom(name: String) {
        val roomItem = RoomItem(
            name = name,
            image = chooseRoomType!!.imageId,
            countOfDevices = COUNT_OF_DEVICE
        )
        val disposable = Single.just(roomItem).subscribeOn(Schedulers.io())
            .subscribe({
                saveRoomUseCase(roomItem)
            }, {
            })
    }

    fun changeViewState(roomTypeItem: RoomType) {
        val listCopy = roomTypeList.copy()
        for (item in listCopy) {
            item.enabled = item.id == roomTypeItem.id
        }
        viewState.setRoomTypeList(listCopy)

    }

    private fun List<RoomType>.copy(): List<RoomType> {
        val copyList = mutableListOf<RoomType>()
        this.map {
            copyList.add(it.copy())
        }
        return copyList
    }

    private fun initRoomList() {
        chooseRoomType = roomTypeList[0] //Choose default list item
        chooseRoomType!!.enabled = true //Set enabled true for listAdapter
        viewState.setRoomTypeList(roomTypeList)
    }

    companion object {
        private const val COUNT_OF_DEVICE =
            3 //This value should come from server, but server is not work
    }
}