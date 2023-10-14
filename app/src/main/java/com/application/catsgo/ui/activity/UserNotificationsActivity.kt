package com.application.catsgo.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.catsgo.R
import com.application.catsgo.adapter.UserNotificationsRecyclerAdapter
import com.application.catsgo.adapter.UserNotificationsUnreadAdapter
import com.application.catsgo.service.Tools
import kotlinx.android.synthetic.main.activity_user_notifications.*

class UserNotificationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_notifications)
        Tools().appColorStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        tvAll.setTextColor(
            ContextCompat.getColor(
                this,
                R.color.bottom_menu_text_clicked
            )
        )

        ivBack.setOnClickListener {
            finish()
        }

        linearAll.setOnClickListener {
            tvAll.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.bottom_menu_text_clicked
                )
            )
            tvUnread.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.color_717171
                )
            )
            rvAll.visibility = View.VISIBLE
            rvUnread.visibility = View.GONE
        }

        linearUnread.setOnClickListener {
            tvAll.setTextColor(ContextCompat.getColor(this, R.color.color_717171))
            tvUnread.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.bottom_menu_text_clicked
                )
            )
            rvAll.visibility = View.GONE
            rvUnread.visibility = View.VISIBLE
        }

        rvAll.adapter = UserNotificationsRecyclerAdapter()
        rvAll.layoutManager = LinearLayoutManager(this)
        rvUnread.adapter = UserNotificationsUnreadAdapter()
        rvUnread.layoutManager = LinearLayoutManager(this)

    }
}