package com.application.catsgo.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.application.catsgo.R
import com.application.catsgo.ui.dialog.RequestSuccessFragment
import com.application.catsgo.service.Tools
import kotlinx.android.synthetic.main.activity_user_choose_tariff.*

class UserChooseTariffActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_choose_tariff)
        supportActionBar?.hide()
        Tools().appColorStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        linearPackageTwo.setBackgroundResource(R.drawable.round_20_shadow_bottom_blue_10)
        packageTwoClickTV()

        linear1.visibility = View.GONE
        linear2.visibility = View.VISIBLE
        linear3.visibility = View.GONE

        linearPackageOne.setOnClickListener {
            linearPackageOne.setBackgroundResource(R.drawable.round_20_shadow_bottom_blue_10)
            linearPackageTwo.setBackgroundResource(R.drawable.round_20_shadow_bottom_10)
            linearPackageThree.setBackgroundResource(R.drawable.round_20_shadow_bottom_10)

            tvPackageOne.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.color_434343
                )
            )
            tvPackageTwo.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.light_blue
                )
            )
            tvPackageThree.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.light_blue
                )
            )

            linear1.visibility = View.VISIBLE
            linear2.visibility = View.GONE
            linear3.visibility = View.GONE
        }
        linearPackageTwo.setOnClickListener {
            linearPackageOne.setBackgroundResource(R.drawable.round_20_shadow_bottom_10)
            linearPackageTwo.setBackgroundResource(R.drawable.round_20_shadow_bottom_blue_10)
            linearPackageThree.setBackgroundResource(R.drawable.round_20_shadow_bottom_10)

            packageTwoClickTV()
            linear1.visibility = View.GONE
            linear2.visibility = View.VISIBLE
            linear3.visibility = View.GONE
        }

        linearPackageThree.setOnClickListener {
            linearPackageOne.setBackgroundResource(R.drawable.round_20_shadow_bottom_10)
            linearPackageTwo.setBackgroundResource(R.drawable.round_20_shadow_bottom_10)
            linearPackageThree.setBackgroundResource(R.drawable.round_20_shadow_bottom_blue_10)

            tvPackageOne.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.light_blue
                )
            )
            tvPackageTwo.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.light_blue
                )
            )
            tvPackageThree.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.color_434343
                )
            )
            linear1.visibility = View.GONE
            linear2.visibility = View.GONE
            linear3.visibility = View.VISIBLE
        }

        btnPay.setOnClickListener {
            val requestSuccessFragment = RequestSuccessFragment()
            requestSuccessFragment.show(supportFragmentManager, "requestSuccessFragment")
        }

        ivBack.setOnClickListener {
            finish()
        }

    }

    private fun packageTwoClickTV() {
        tvPackageOne.setTextColor(
            ContextCompat.getColor(
                this,
                R.color.light_blue
            )
        )
        tvPackageTwo.setTextColor(
            ContextCompat.getColor(
                this,
                R.color.color_434343
            )
        )
        tvPackageThree.setTextColor(
            ContextCompat.getColor(
                this,
                R.color.light_blue
            )
        )
    }
}