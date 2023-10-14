package com.application.catsgo.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.application.catsgo.adapter.UserPetRecyclerAdapter
import com.application.catsgo.service.Tools
import com.application.catsgo.util.funClearIntent
import kotlinx.android.synthetic.main.activity_user_main.*
import kotlinx.android.synthetic.main.activity_user_main.cardAccount
import kotlinx.android.synthetic.main.activity_user_main.imgAccount
import kotlinx.android.synthetic.main.activity_user_main.imgMessages
import kotlinx.android.synthetic.main.activity_user_main.ivHome
import kotlinx.android.synthetic.main.activity_user_main.ivNotifications
import kotlinx.android.synthetic.main.activity_user_main.linearAccount
import kotlinx.android.synthetic.main.activity_user_main.linearBottom
import kotlinx.android.synthetic.main.activity_user_main.linearHome
import kotlinx.android.synthetic.main.activity_user_main.linearMessages
import kotlinx.android.synthetic.main.activity_user_main.tvAccount
import kotlinx.android.synthetic.main.activity_user_main.tvHome
import kotlinx.android.synthetic.main.activity_user_main.tvMessages
import kotlinx.android.synthetic.main.activity_user_messages.*

class UserMainActivity : AppCompatActivity() {

    private var layoutManagerCard: RecyclerView.LayoutManager? = null
    private var adapterCard: RecyclerView.Adapter<UserPetRecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_main)
        Tools().appColorStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        layoutManagerCard = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        rvCat.layoutManager = layoutManagerCard
        adapterCard = UserPetRecyclerAdapter()
        rvCat.adapter = adapterCard

        tvHome.setTextColor(resources.getColor(R.color.bottom_menu_text_clicked))
        ivHome.setImageResource(R.drawable.pet_after_click)
        bottomMenu()

        ivNotifications.setOnClickListener {
            val intent = Intent(this, UserNotificationsActivity::class.java)
            startActivity(intent)
        }

        linearHomeClick()

        btnCreateRequest.setOnClickListener {
            val intent = Intent(this, PickDateActivity::class.java)
            startActivity(intent)
        }

        linearBottom.setOnClickListener { }

        linearAdd.setOnClickListener {
            val intent = Intent(this, UserAddCatActivity::class.java)
            startActivity(intent)
        }

        linearUpdate.setOnClickListener {
            val intent = Intent(this, UserMyCatsActivity::class.java)
            startActivity(intent)
        }

        cardAccount.setOnClickListener {
            funClearIntent(UserAccountActivity())
        }

    }

    override fun onBackPressed() {
    }

    private fun bottomMenu() {
        linearHomeClick()

        linearMessages.setOnClickListener {

            //val intent = Intent(this, UserMessagesActivity::class.java)
            //startActivity(intent)
            this.startActivity(
                Intent(
                    this,
                    UserMessagesActivity::class.java
                ).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            )

            tvHome.setTextColor(resources.getColor(R.color.bottom_menu_text))
            ivHome.setImageResource(R.drawable.pet_before_click)

            tvMessages.setTextColor(resources.getColor(R.color.bottom_menu_text_clicked))
            imgMessages.setImageResource(R.drawable.sms_after_click)

            tvAccount.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgAccount.setImageResource(R.drawable.profile_before_click)

        }
        linearAccount.setOnClickListener {

            //val intent = Intent(this, UserAccountActivity::class.java)
            //startActivity(intent)
            this.startActivity(
                Intent(
                    this,
                    UserAccountActivity::class.java
                ).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            )

            tvHome.setTextColor(resources.getColor(R.color.bottom_menu_text))
            ivHome.setImageResource(R.drawable.pet_before_click)

            tvMessages.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgMessages.setImageResource(R.drawable.sms_before_click)

            tvAccount.setTextColor(resources.getColor(R.color.bottom_menu_text_clicked))
            imgAccount.setImageResource(R.drawable.profile_after_click)
        }

        /*linearAppointment.setOnClickListener {

            //val intent = Intent(this, UserAccountActivity::class.java)
            //startActivity(intent)
            this.startActivity(
                Intent(
                    this,
                    UserAppointmentActivity::class.java
                ).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            )

            tvHome.setTextColor(resources.getColor(R.color.bottom_menu_text))
            ivHome.setImageResource(R.drawable.pet_before_click)

            tvMessages.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgMessages.setImageResource(R.drawable.sms_before_click)

            tvAccount.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgAccount.setImageResource(R.drawable.profile_before_click)

            /*tvAppointment.setTextColor(resources.getColor(R.color.bottom_menu_text_clicked))
            ivAppointment.setImageResource(R.drawable.icon_appointment_clicked)*/
        }*/
    }

    private fun linearHomeClick() {
        linearHome.setOnClickListener {

            tvHome.setTextColor(resources.getColor(R.color.bottom_menu_text_clicked))
            ivHome.setImageResource(R.drawable.pet_after_click)

            tvMessages.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgMessages.setImageResource(R.drawable.sms_before_click)

            tvAccount.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgAccount.setImageResource(R.drawable.profile_before_click)

        }
    }
}