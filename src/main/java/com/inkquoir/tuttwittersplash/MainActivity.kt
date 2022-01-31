package com.inkquoir.tuttwittersplash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.AnimationUtils
import com.inkquoir.tuttwittersplash.databinding.ActivityMainBinding

public const val SPLASH_TIME = 4000L

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler(Looper.myLooper()!!).postDelayed(
            {
                val intent = Intent(this, NextActivity::class.java)
                startActivity(intent)
                finish()
            },
            SPLASH_TIME
        )

        val fadeInAnim = AnimationUtils.loadAnimation(this, R.anim.fade_in_anim)
        binding.ivTwitterLogo.animation = fadeInAnim

    }
}