package com.application.catsgo.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.application.catsgo.R
import com.application.catsgo.service.Tools
import kotlinx.android.synthetic.main.activity_user_camera.*

class UserCameraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_camera)
        Tools().appColorStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        ivBack.setOnClickListener {
            finish()
        }

        relativeFirstCamera.setOnClickListener {
            funIntentCameraFull()
        }

        relativeSecondCamera.setOnClickListener {
            funIntentCameraFull()
        }

        relativeThirdCamera.setOnClickListener {
            funIntentCameraFull()
        }

    }

    override fun onBackPressed() {
        finish()
    }

    private fun funIntentCameraFull() {
        val intent = Intent(this, CameraFullScreenActivity::class.java)
        startActivity(intent)
    }
}