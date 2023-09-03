package com.example.gamechronicle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {
    private val load = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            val loginIntent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(loginIntent)
            finish()
        }, load)

        supportActionBar?.hide()
    }
}