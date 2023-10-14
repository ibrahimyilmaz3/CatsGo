package com.application.catsgo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.application.catsgo.adapter.ChooseDistrictRecyclerAdapter
import com.application.catsgo.service.Tools
import com.application.catsgo.util.BaseAppCompatActivity
import com.application.catsgo.util.ChooseLocation
import com.application.catsgo.util.funClearIntent
import kotlinx.android.synthetic.main.activity_user_choose_district.*

@Deprecated("Removed from design")
class UserChooseDistrictActivity : BaseAppCompatActivity() {

    private var layoutManagerCard: RecyclerView.LayoutManager? = null
    private var adapterCard: RecyclerView.Adapter<ChooseDistrictRecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_choose_district)
        Tools().appColorStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        //RecyclerView
        layoutManagerCard = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        rvChooseDistrict.layoutManager = layoutManagerCard
        adapterCard = ChooseDistrictRecyclerAdapter()

        rvChooseDistrict.adapter = adapterCard
        //RecyclerView

        /*cardBack.setOnClickListener {
            val intent = Intent(this, UserAppointmentActivity::class.java)
            startActivity(intent)
        }*/

        btnChooseDistrict.setOnClickListener {
            ChooseLocation.city = "Adana"
            funClearIntent(UserAppointmentActivity())
        }
    }

}