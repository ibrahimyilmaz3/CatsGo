package com.application.catsgo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.application.catsgo.adapter.UserPetUnderCareRecyclerAdapter
import com.application.catsgo.service.Tools
import com.application.catsgo.util.funIntent
import kotlinx.android.synthetic.main.activity_user_my_requests.*

class UserMyRequestsActivity : AppCompatActivity() {

    private var layoutManagerCard: RecyclerView.LayoutManager? = null
    private var adapterCard: RecyclerView.Adapter<UserPetUnderCareRecyclerAdapter.ViewHolder>? =
        null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_my_requests)
        supportActionBar?.hide()
        Tools().appColorStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        layoutManagerCard = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        rvCat.layoutManager = layoutManagerCard

        adapterCard = UserPetUnderCareRecyclerAdapter()
        rvCat.adapter = adapterCard

        ivBack.setOnClickListener {
            funIntent(UserAccountActivity())
        }
    }
}