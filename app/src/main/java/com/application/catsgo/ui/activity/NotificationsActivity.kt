package com.application.catsgo.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.application.catsgo.adapter.NotificationsRecyclerAdapter
import com.application.catsgo.adapter.NotificationsUnreadAdapter
import com.application.catsgo.service.Tools
import kotlinx.android.synthetic.main.activity_clinic.*
import kotlinx.android.synthetic.main.activity_notifications.*
import kotlinx.android.synthetic.main.activity_notifications.ivBack
import kotlinx.android.synthetic.main.activity_notifications.linearAll
import kotlinx.android.synthetic.main.activity_notifications.linearUnread
import kotlinx.android.synthetic.main.activity_notifications.rvAll
import kotlinx.android.synthetic.main.activity_notifications.rvUnread
import kotlinx.android.synthetic.main.activity_notifications.tvAll
import kotlinx.android.synthetic.main.activity_notifications.tvUnread
import kotlinx.android.synthetic.main.activity_user_notifications.*

class NotificationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)
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


        rvAll.adapter = NotificationsRecyclerAdapter()
        rvAll.layoutManager = LinearLayoutManager(this)
        rvUnread.adapter = NotificationsUnreadAdapter()
        rvUnread.layoutManager = LinearLayoutManager(this)

    }
}