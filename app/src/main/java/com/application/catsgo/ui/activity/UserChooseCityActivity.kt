package com.application.catsgo.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.application.catsgo.adapter.ChooseCityRecyclerAdapter
import com.application.catsgo.service.Tools
import com.application.catsgo.util.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_user_choose_city.*

@Deprecated("Removed from design")
class UserChooseCityActivity : BaseAppCompatActivity() {

    private var layoutManagerCard: RecyclerView.LayoutManager? = null
    private var adapterCard: RecyclerView.Adapter<ChooseCityRecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_choose_city)
        Tools().appColorStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        //RecyclerView
        layoutManagerCard = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        rvChooseCity.layoutManager = layoutManagerCard
        adapterCard = ChooseCityRecyclerAdapter()
        rvChooseCity.adapter = adapterCard
        //RecyclerView

        /*cardBack.setOnClickListener {
            val intent = Intent(this, UserAppointmentActivity::class.java)
            startActivity(intent)
        }*/

        btnChooseCity.setOnClickListener {
            val intent = Intent(this, UserChooseDistrictActivity::class.java)
            startActivity(intent)
        }

        ivBack.setOnClickListener {
            finish()
        }

    }
}