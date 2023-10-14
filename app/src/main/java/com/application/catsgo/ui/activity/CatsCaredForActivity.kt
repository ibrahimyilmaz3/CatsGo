package com.application.catsgo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.application.catsgo.adapter.CatsCaredForRecyclerAdapter
import com.application.catsgo.service.Tools
import kotlinx.android.synthetic.main.activity_main.rvCat
import kotlinx.android.synthetic.main.activity_cats_cared_for.*

class CatsCaredForActivity : AppCompatActivity() {

    private var layoutManagerCard: RecyclerView.LayoutManager? = null
    private var adapterCardCaredFor: RecyclerView.Adapter<CatsCaredForRecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cats_cared_for)
        supportActionBar?.hide()
        Tools().appColorStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        layoutManagerCard = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        rvCat.layoutManager = layoutManagerCard

        adapterCardCaredFor = CatsCaredForRecyclerAdapter()
        rvCat.adapter = adapterCardCaredFor

        ivBack.setOnClickListener {
            finish()
        }

    }
}