package com.sixcandoit.decisiontoleave.presentation.splash.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sixcandoit.decisiontoleave.databinding.ActivitySplashBinding
import com.sixcandoit.decisiontoleave.presentation.home.view.HomeActivity
import java.util.*
import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timer().schedule(1000) {
            val intent = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}