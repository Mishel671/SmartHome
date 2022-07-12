package com.example.smarthome.presentation.addroom

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.smarthome.R
import com.example.smarthome.databinding.FragmentAddRoomBinding
import com.example.smarthome.domain.RoomType
import com.example.smarthome.presentation.addroom.adapter.RoomTypeListAdapter
import com.example.smarthome.presentation.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class AddRoomFragment : MvpAppCompatFragment(R.layout.fragment_add_room), AddRoomView {

    private val binding by viewBinding(FragmentAddRoomBinding::bind)

    @Inject
    lateinit var presenterProvider: Provider<AddRoomPresenter>

    private val presenter by moxyPresenter { presenterProvider.get() }

    private val roomTypeAdapter = RoomTypeListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        setButtonListener()
    }

    private fun setRecyclerView() {
        with(binding.rvRoomType) {
            layoutManager = GridLayoutManager(context, NUMBER_OF_COLUMNS)
            adapter = roomTypeAdapter
            recycledViewPool.setMaxRecycledViews(
                RoomTypeListAdapter.VIEW_TYPE_ENABLED,
                RoomTypeListAdapter.MAX_POOL_SIZE
            )
            recycledViewPool.setMaxRecycledViews(
                RoomTypeListAdapter.VIEW_TYPE_DISABLED,
                RoomTypeListAdapter.MAX_POOL_SIZE
            )
            roomTypeAdapter.onRoomItemClickListener = {

                presenter.changeViewState(it)
            }
        }
    }

    private fun setButtonListener(){
        binding.btAddRoom.setOnClickListener {
            presenter.saveRoom("Kitchen")
        }
    }

    override fun setRoomTypeList(roomTypeList: List<RoomType>) {

        roomTypeAdapter.submitList(roomTypeList)
    }

    companion object {
        fun newInstance() = AddRoomFragment()
        private const val NUMBER_OF_COLUMNS = 3
    }
}