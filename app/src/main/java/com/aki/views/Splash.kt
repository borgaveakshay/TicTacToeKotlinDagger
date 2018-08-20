package com.aki.views

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import com.aki.R


class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        timer(3000, 1000).start()
    }

    private fun timer(millisInFuture: Long, countDownInterval: Long): CountDownTimer {
        return object : CountDownTimer(millisInFuture, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                // do nothing
            }

            override fun onFinish() {
                startActivity(Intent(this@Splash, GameAcivity::class.java))
                this@Splash.finish()
            }
        }
    }
}
