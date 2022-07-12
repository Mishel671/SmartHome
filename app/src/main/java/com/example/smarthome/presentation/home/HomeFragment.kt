package com.example.smarthome.presentation.home

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.WindowInsetsControllerCompat
import com.example.smarthome.R
import com.example.smarthome.databinding.FragmentHomeBinding
import com.example.smarthome.presentation.addroom.AddRoomFragment
import com.example.smarthome.presentation.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider


@AndroidEntryPoint
class HomeFragment : MvpAppCompatFragment(R.layout.fragment_home), HomeView {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    @Inject
    lateinit var presenterProvider: Provider<HomePresenter>

    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setLightStatusBar()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btAddRoom.setOnClickListener {
            launchAddRoomFragment()
        }
    }

    private fun setLightStatusBar(){
        val window = requireActivity().window
        val decorView = window.decorView
        val wic = WindowInsetsControllerCompat(window, decorView)
        wic.isAppearanceLightStatusBars = false
    }

    private fun launchAddRoomFragment(){
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, AddRoomFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    override fun setRoomList() {
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

}