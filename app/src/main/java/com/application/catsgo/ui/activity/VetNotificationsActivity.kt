package com.application.catsgo.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.application.catsgo.adapter.Vet2Adapter
import com.application.catsgo.adapter.Vet2UnreadAdapter
import com.application.catsgo.service.Tools
import kotlinx.android.synthetic.main.activity_vet_notifications.*

class VetNotificationsActivity : AppCompatActivity() {

    private var adapterCard: RecyclerView.Adapter<Vet2Adapter.ViewHolder>? =
        null
    private var adapterCard2: RecyclerView.Adapter<Vet2UnreadAdapter.ViewHolder>? =
        null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vet_notifications)
        Tools().appColorStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        //toast("this is vet notifications")

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


        rvAll.layoutManager = LinearLayoutManager(this)
        adapterCard = Vet2Adapter()
        rvAll.adapter = adapterCard

        rvUnread.layoutManager = LinearLayoutManager(this)
        adapterCard2 = Vet2UnreadAdapter()
        rvUnread.adapter = adapterCard2

    }
}