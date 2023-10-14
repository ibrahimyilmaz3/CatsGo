package com.application.catsgo.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.application.catsgo.adapter.PetRecyclerAdapter
import com.application.catsgo.service.Tools
import com.application.catsgo.util.funClearIntent
import com.application.catsgo.util.funIntent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.imgAccount
import kotlinx.android.synthetic.main.activity_main.imgMessages
import kotlinx.android.synthetic.main.activity_main.ivNotifications
import kotlinx.android.synthetic.main.activity_main.linearAccount
import kotlinx.android.synthetic.main.activity_main.linearBottom
import kotlinx.android.synthetic.main.activity_main.linearHome
import kotlinx.android.synthetic.main.activity_main.linearMessages
import kotlinx.android.synthetic.main.activity_main.rvCat
import kotlinx.android.synthetic.main.activity_main.tvAccount
import kotlinx.android.synthetic.main.activity_main.tvHome
import kotlinx.android.synthetic.main.activity_main.tvMessages

class MainActivity : AppCompatActivity() {

    private var layoutManagerCard: RecyclerView.LayoutManager? = null
    private var adapterCard: RecyclerView.Adapter<PetRecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Tools().appColorStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        layoutManagerCard = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        rvCat.layoutManager = layoutManagerCard

        adapterCard = PetRecyclerAdapter()
        rvCat.adapter = adapterCard

        tvHome.setTextColor(resources.getColor(R.color.bottom_menu_text_clicked))
        imgHome.setImageResource(R.drawable.pet_after_click)
        bottomMenu()

        ivNotifications.setOnClickListener {
            funIntent(NotificationsActivity())
        }

        linearBottom.setOnClickListener {  }

        cardAccount.setOnClickListener {
            funClearIntent(AccountActivity())
        }

    }

    override fun onBackPressed() {
    }

    private fun bottomMenu() {
        linearHome.setOnClickListener {

            tvHome.setTextColor(resources.getColor(R.color.bottom_menu_text_clicked))
            imgHome.setImageResource(R.drawable.pet_after_click)

            tvMessages.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgMessages.setImageResource(R.drawable.sms_before_click)

            tvAccount.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgAccount.setImageResource(R.drawable.profile_before_click)

        }
        linearMessages.setOnClickListener {

            //val intent = Intent(this, MessagesActivity::class.java)
            //startActivity(intent)

            this.startActivity(
                Intent(
                    this,
                    MessagesActivity::class.java
                ).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            )

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