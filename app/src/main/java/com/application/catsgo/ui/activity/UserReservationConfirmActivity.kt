package com.application.catsgo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.application.catsgo.R
import com.application.catsgo.service.Tools
import com.application.catsgo.util.funClearIntent
import kotlinx.android.synthetic.main.activity_user_reservation_confirm.*

class UserReservationConfirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_reservation_confirm)
        Tools().appColorStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        btnGoBack.setOnClickListener {
            funClearIntent(UserAppointmentActivity())
        }
    }

    override fun onBackPressed() {

    }
}