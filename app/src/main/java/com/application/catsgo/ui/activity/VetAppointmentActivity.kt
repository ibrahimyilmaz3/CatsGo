package com.application.catsgo.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.application.catsgo.adapter.VetAppointmentsRecyclerAdapter
import com.application.catsgo.service.Tools
import com.application.catsgo.util.funIntent
import kotlinx.android.synthetic.main.activity_vet_appointment.*

@Deprecated("Removed from design")
class VetAppointmentActivity : AppCompatActivity() {

    private var layoutManagerCard: RecyclerView.LayoutManager? = null
    private var adapterCard: RecyclerView.Adapter<VetAppointmentsRecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vet_appointment)
        Tools().appColorStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        tvAppointment.setTextColor(resources.getColor(R.color.bottom_menu_text_clicked))
        ivAppointment.setImageResource(R.drawable.note_after_click)

        bottomMenu()

        layoutManagerCard = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        rvAppointment.layoutManager = layoutManagerCard
        adapterCard = VetAppointmentsRecyclerAdapter()
        rvAppointment.adapter = adapterCard

        ivNotifications.setOnClickListener {
            funIntent(VetNotificationsActivity())
        }
    }

    override fun onBackPressed() {
    }

    private fun bottomMenu() {

        linearClinic.setOnClickListener {

            this.startActivity(
                Intent(
                    this,
                    VetMainActivity::class.java
                ).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            )

            tvClinic.setTextColor(resources.getColor(R.color.bottom_menu_text_clicked))
            ivClinic.setImageResource(R.drawable.icon_appointment_clicked)

            tvMessages.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgMessages.setImageResource(R.drawable.sms_before_click)

            tvAccount.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgAccount.setImageResource(R.drawable.profile_before_click)

            tvAppointment.setTextColor(resources.getColor(R.color.bottom_menu_text))
            ivAppointment.setImageResource(R.drawable.note_before_click)

        }

        linearMessages.setOnClickListener {

            //val intent = Intent(this, UserMessagesActivity::class.java)
            //startActivity(intent)
            this.startActivity(
                Intent(
                    this,
                    VetMessagesActivity::class.java
                ).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            )

            tvClinic.setTextColor(resources.getColor(R.color.bottom_menu_text))
            ivClinic.setImageResource(R.drawable.icon_appointment_not_clicked)

            tvMessages.setTextColor(resources.getColor(R.color.bottom_menu_text_clicked))
            imgMessages.setImageResource(R.drawable.sms_after_click)

            tvAccount.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgAccount.setImageResource(R.drawable.profile_before_click)

            tvAppointment.setTextColor(resources.getColor(R.color.bottom_menu_text))
            ivAppointment.setImageResource(R.drawable.note_before_click)

        }
        linearAccount.setOnClickListener {

            //val intent = Intent(this, UserAccountActivity::class.java)
            //startActivity(intent)
            this.startActivity(
                Intent(
                    this,
                    VetAccountActivity::class.java
                ).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            )

            tvClinic.setTextColor(resources.getColor(R.color.bottom_menu_text))
            ivClinic.setImageResource(R.drawable.icon_appointment_not_clicked)

            tvMessages.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgMessages.setImageResource(R.drawable.sms_before_click)

            tvAccount.setTextColor(resources.getColor(R.color.bottom_menu_text_clicked))
            imgAccount.setImageResource(R.drawable.profile_after_click)

            tvAppointment.setTextColor(resources.getColor(R.color.bottom_menu_text))
            ivAppointment.setImageResource(R.drawable.note_before_click)
        }

        linearAppointment.setOnClickListener {

            //val intent = Intent(this, UserAccountActivity::class.java)
            //startActivity(intent)
            this.startActivity(
                Intent(
                    this,
                    VetAppointmentActivity::class.java
                ).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            )

            tvClinic.setTextColor(resources.getColor(R.color.bottom_menu_text))
            ivClinic.setImageResource(R.drawable.icon_appointment_not_clicked)

            tvMessages.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgMessages.setImageResource(R.drawable.sms_before_click)

            tvAccount.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgAccount.setImageResource(R.drawable.profile_before_click)

            tvAppointment.setTextColor(resources.getColor(R.color.bottom_menu_text_clicked))
            ivAppointment.setImageResource(R.drawable.note_before_click)
        }
    }


}