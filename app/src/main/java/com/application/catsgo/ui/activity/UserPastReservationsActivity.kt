package com.application.catsgo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.application.catsgo.adapter.UserPastReservationsRecyclerAdapter
import com.application.catsgo.service.Tools
import kotlinx.android.synthetic.main.activity_user_past_reservations.*

@Deprecated("Removed from design")
class UserPastReservationsActivity : AppCompatActivity() {

    private var layoutManagerCard: RecyclerView.LayoutManager? = null
    private var adapterCard: RecyclerView.Adapter<UserPastReservationsRecyclerAdapter.ViewHolder>? =
        null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_past_reservations)
        Tools().appColorStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        layoutManagerCard = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        rvPastReservations.layoutManager = layoutManagerCard

        adapterCard = UserPastReservationsRecyclerAdapter()
        rvPastReservations.adapter = adapterCard

        ivBack.setOnClickListener {
            finish()
        }
    }

    override fun onBackPressed() {
        finish()
    }

}