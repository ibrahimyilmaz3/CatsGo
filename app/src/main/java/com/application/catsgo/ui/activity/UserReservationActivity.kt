package com.application.catsgo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import com.application.catsgo.R
import com.application.catsgo.adapter.TimeAdapter
import com.application.catsgo.service.Calendar
import com.application.catsgo.service.Tools
import com.application.catsgo.util.funIntent
import kotlinx.android.synthetic.main.activity_user_reservation.*

class UserReservationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_reservation)
        Tools().appColorStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        Calendar(this, calendar_recyclerView)
        timeRecyclerView.layoutManager =
            GridLayoutManager(this, 6, GridLayoutManager.VERTICAL, false)
        timeRecyclerView.adapter = TimeAdapter()

        btnCompleteReservation.setOnClickListener {
            funIntent(UserReservationConfirmActivity())
        }

        linearChooseService.setOnClickListener {
            funIntent(UserChooseServiceActivity())
        }

        ivBack.setOnClickListener {
            //Log.d("TAG", "You clicked me")
            finish()
        }
    }
}