package com.application.catsgo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.content.res.AppCompatResources
import com.application.catsgo.R
import com.application.catsgo.service.Tools
import kotlinx.android.synthetic.main.activity_user_choose_service.*

class UserChooseServiceActivity : AppCompatActivity() {

    private var checked1 = 0
    private var checked2 = 0
    private var checked3 = 0
    private var checked4 = 0
    private var checked5 = 0
    private var checked6 = 0
    private var checked7 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_choose_service)
        Tools().appColorStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        ivBack.setOnClickListener {
            finish()
        }

        linearCombinationVaccine.setOnClickListener {
            checked1 = if (checked1 == 0) {
                ivCombinationVaccine.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.image_checked
                    )
                )
                1
            } else {
                ivCombinationVaccine.setImageDrawable(null)
                0
            }
        }

        linearRabiesVaccine.setOnClickListener {
            checked2 = if (checked2 == 0) {
                ivRabiesVaccine.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.image_checked
                    )
                )
                1
            } else {
                ivRabiesVaccine.setImageDrawable(null)
                0
            }
        }

        linearChip.setOnClickListener {
            checked3 = if (checked3 == 0) {
                ivChip.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.image_checked
                    )
                )
                1
            } else {
                ivChip.setImageDrawable(null)
                0
            }
        }

        linearWashTrim.setOnClickListener {
            checked4 = if (checked4 == 0) {
                ivWashTrim.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.image_checked
                    )
                )
                1
            } else {
                ivWashTrim.setImageDrawable(null)
                0
            }
        }

        linearTrimNail.setOnClickListener {
            checked5 = if (checked5 == 0) {
                ivTrimNail.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.image_checked
                    )
                )
                1
            } else {
                ivTrimNail.setImageDrawable(null)
                0
            }
        }

        linearExamination.setOnClickListener {
            checked6 = if (checked6 == 0) {
                ivExamination.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.image_checked
                    )
                )
                1
            } else {
                ivExamination.setImageDrawable(null)
                0
            }
        }

        linearCare.setOnClickListener {
            checked7 = if (checked7 == 0) {
                ivCare.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.image_checked
                    )
                )
                1
            } else {
                ivCare.setImageDrawable(null)
                0
            }
        }

        btnChooseService.setOnClickListener {
            finish()
        }

    }
}