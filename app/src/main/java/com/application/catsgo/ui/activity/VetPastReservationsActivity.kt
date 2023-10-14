package com.application.catsgo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.application.catsgo.adapter.VetPastReservationsRecyclerAdapter
import com.application.catsgo.service.Tools
import kotlinx.android.synthetic.main.activity_vet_past_reservations.*

@Deprecated("Removed from design")
class VetPastReservationsActivity : AppCompatActivity() {

    private var layoutManagerCard: RecyclerView.LayoutManager? = null
    private var adapterCard: RecyclerView.Adapter<VetPastReservationsRecyclerAdapter.ViewHolder>? =
        null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vet_past_reservations)
        Tools().appColorStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        layoutManagerCard = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        rvPastReservations.layoutManager = layoutManagerCard

        adapterCard = VetPastReservationsRecyclerAdapter()
        rvPastReservations.adapter = adapterCard

        ivBack.setOnClickListener {
            finish()
        }
    }

    override fun onBackPressed() {
        finish()
    }
}