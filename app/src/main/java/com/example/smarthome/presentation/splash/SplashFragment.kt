package com.example.smarthome.presentation.splash

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import androidx.fragment.app.Fragment
import com.example.smarthome.R
import com.example.smarthome.databinding.FragmentSplashBinding
import com.example.smarthome.presentation.home.HomeFragment
import com.example.smarthome.presentation.viewBinding


class SplashFragment : Fragment(R.layout.fragment_splash){

    private val binding by viewBinding(FragmentSplashBinding::bind)

    override fun onStart() {
        super.onStart()
        val animation = AnimatorInflater.loadAnimator(context,R.animator.logo_animator) as AnimatorSet
        animation.setTarget(binding.ivLogo)
        animation.addListener(object : AnimListener(){
            override fun onAnimationEnd(p0: Animator?) {
                launchNextScreen()
            }
        })
        animation.start()
    }

    private fun launchNextScreen(){
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, HomeFragment.newInstance())
            .commit()
    }

    companion object {
        fun newInstance() = SplashFragment()
    }
}