package com.application.catsgo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.content.res.AppCompatResources
import com.application.catsgo.R
import com.application.catsgo.service.Tools
import com.application.catsgo.util.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_user_rate_service.*

class UserRateServiceActivity : BaseAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_rate_service)
        Tools().appColorStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        ivBack.setOnClickListener {
            finish()
        }

        btnRate.setOnClickListener {
            finish()
        }

        //CustomRatingBar
        //
        firstStar.setOnClickListener {
            firstStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_full_blue
                )
            )
            secondStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_empty_blue
                )
            )
            thirdStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_empty_blue
                )
            )
            fourthStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_empty_blue
                )
            )
            fifthStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_empty_blue
                )
            )
        }
        secondStar.setOnClickListener {
            firstStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_full_blue
                )
            )
            secondStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_full_blue
                )
            )
            thirdStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_empty_blue
                )
            )
            fourthStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_empty_blue
                )
            )
            fifthStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_empty_blue
                )
            )
        }
        thirdStar.setOnClickListener {
            firstStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_full_blue
                )
            )
            secondStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_full_blue
                )
            )
            thirdStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_full_blue
                )
            )
            fourthStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_empty_blue
                )
            )
            fifthStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_empty_blue
                )
            )
        }
        fourthStar.setOnClickListener {
            firstStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_full_blue
                )
            )
            secondStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_full_blue
                )
            )
            thirdStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_full_blue
                )
            )
            fourthStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_full_blue
                )
            )
            fifthStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_empty_blue
                )
            )
        }
        fifthStar.setOnClickListener {
            firstStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_full_blue
                )
            )
            secondStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_full_blue
                )
            )
            thirdStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_full_blue
                )
            )
            fourthStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_full_blue
                )
            )
            fifthStar.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    R.drawable.star_full_blue
                )
            )
        }
        //
        //CustomRatingBar
    }
}