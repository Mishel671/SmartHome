package com.example.smarthome.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smarthome.R
import com.example.smarthome.databinding.ActivityMainBinding
import com.example.smarthome.presentation.splashscreen.SplashFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, SplashFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }
}