package com.application.catsgo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.application.catsgo.adapter.VetMyClinicRecyclerAdapter
import com.application.catsgo.service.Tools
import kotlinx.android.synthetic.main.activity_vet_my_clinics.*

@Deprecated("Removed from design")
class VetMyClinicsActivity : AppCompatActivity() {

    private var layoutManagerCard: RecyclerView.LayoutManager? = null
    private var adapterCardMy: RecyclerView.Adapter<VetMyClinicRecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vet_my_clinics)
        supportActionBar?.hide()
        Tools().appColorStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        ivBack.setOnClickListener {
            finish()
        }

        layoutManagerCard = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        rvClinic.layoutManager = layoutManagerCard
        adapterCardMy = VetMyClinicRecyclerAdapter()
        rvClinic.adapter = adapterCardMy

    }
}