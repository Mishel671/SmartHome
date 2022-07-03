package com.example.smarthome.presentation.splashscreen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.smarthome.R
import com.example.smarthome.databinding.FragmentSplashBinding
import com.example.smarthome.presentation.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import java.util.*
import javax.inject.Inject
import javax.inject.Provider


@AndroidEntryPoint
class SplashFragment : MvpAppCompatFragment(R.layout.fragment_splash), SplashView {

    private val binding by viewBinding(FragmentSplashBinding::bind)

    @Inject
    lateinit var presenterProvider: Provider<SplashPresenter>

    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val uuid: String = UUID.randomUUID().toString()
        presenter.registration(uuid)
    }


    override fun launchNextScreen() {
        Toast.makeText(requireActivity(), "LaunchNextScreen", Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance() = SplashFragment()
    }
}