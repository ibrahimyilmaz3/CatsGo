package com.application.catsgo.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.application.catsgo.R
import com.application.catsgo.service.Tools
import kotlinx.android.synthetic.main.activity_user_vet_info.*

class UserVetInfoActivity : AppCompatActivity() {

    private var selected = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_vet_info)
        Tools().appColorStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        linearReservation.setOnClickListener {
            val intent = Intent(this, UserReservationActivity::class.java)
            startActivity(intent)
        }

        linearMessages.setOnClickListener {
            val intent = Intent(this, UserMessageContentActivity::class.java)
            startActivity(intent)
        }

        ivBack.setOnClickListener {
            finish()
        }

    }
}