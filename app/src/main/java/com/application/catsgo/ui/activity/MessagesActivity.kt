package com.application.catsgo.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.application.catsgo.adapter.MessagesRecyclerAdapter
import com.application.catsgo.service.Tools
import com.application.catsgo.util.BaseAppCompatActivity
import com.application.catsgo.util.funClearIntent
import com.application.catsgo.util.funIntent
import kotlinx.android.synthetic.main.activity_messages.*

class MessagesActivity : BaseAppCompatActivity() {

    private var layoutManagerCard: RecyclerView.LayoutManager? = null
    private var adapterCard: RecyclerView.Adapter<MessagesRecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)
        supportActionBar?.hide()
        Tools().appColorStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        tvMessages.setTextColor(resources.getColor(R.color.bottom_menu_text_clicked))
        imgMessages.setImageResource(R.drawable.sms_after_click)
        bottomMenu()

        ivNotifications.setOnClickListener {
            funIntent(NotificationsActivity())
        }

        //RecyclerView
        layoutManagerCard = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        rvMessages.layoutManager = layoutManagerCard
        adapterCard = MessagesRecyclerAdapter()
        rvMessages.adapter = adapterCard
        //RecyclerView

        linearBottom.setOnClickListener { }

        cardAccount.setOnClickListener {
            funClearIntent(AccountActivity())
        }

    }

    override fun onBackPressed() {
    }

    private fun bottomMenu() {

        linearHome.setOnClickListener {

            //val intent = Intent(this, MainActivity::class.java)
            //startActivity(intent)
            this.startActivity(
                Intent(
                    this,
                    MainActivity::class.java
                ).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            )
            tvHome.setTextColor(resources.getColor(R.color.bottom_menu_text_clicked))
            imgHome.setImageResource(R.drawable.pet_after_click)

            tvMessages.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgMessages.setImageResource(R.drawable.sms_before_click)

            tvAccount.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgAccount.setImageResource(R.drawable.profile_before_click)
        }

        linearMessages.setOnClickListener {

            tvHome.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgHome.setImageResource(R.drawable.pet_before_click)

            tvMessages.setTextColor(resources.getColor(R.color.bottom_menu_text_clicked))
            imgMessages.setImageResource(R.drawable.sms_after_click)

            tvAccount.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgAccount.setImageResource(R.drawable.profile_before_click)

        }
        linearAccount.setOnClickListener {

            //val intent = Intent(this, AccountActivity::class.java)
            //startActivity(intent)
            this.startActivity(
                Intent(
                    this,
                    AccountActivity::class.java
                ).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            )

            tvHome.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgHome.setImageResource(R.drawable.pet_before_click)

            tvMessages.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgMessages.setImageResource(R.drawable.sms_before_click)

            tvAccount.setTextColor(resources.getColor(R.color.bottom_menu_text_clicked))
            imgAccount.setImageResource(R.drawable.profile_after_click)

        }
    }
}