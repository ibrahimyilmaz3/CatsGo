package com.application.catsgo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.content.res.AppCompatResources
import com.application.catsgo.R
import com.application.catsgo.service.Tools
import kotlinx.android.synthetic.main.activity_tasks.*

class TasksActivity : AppCompatActivity() {

    private var checked1 = 0
    private var checked2 = 0
    private var checked3 = 0
    private var checked4 = 0
    private var checked5 = 0
    private var checked6 = 0
    private var checked7 = 0
    private var checked8 = 0
    private var checked9 = 0
    private var checked10 = 0
    private var checked11 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)
        Tools().appColorStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        ivBack.setOnClickListener {
            finish()
        }

        linearFeed.setOnClickListener {
            checked1 = if (checked1 == 0) {
                imgFeed.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.image_checked
                    )
                )
                1
            } else {
                imgFeed.setImageDrawable(null)
                0
            }
        }

        linearBoxClean.setOnClickListener {
            checked2 = if (checked2 == 0) {
                imgBoxClean.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.image_checked
                    )
                )
                1
            } else {
                imgBoxClean.setImageDrawable(null)
                0
            }
        }

        linearWaterChange.setOnClickListener {
            checked3 = if (checked3 == 0) {
                imgWaterChange.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.image_checked
                    )
                )
                1
            } else {
                imgWaterChange.setImageDrawable(null)
                0
            }
        }

        linearAirOut.setOnClickListener {
            checked4 = if (checked4 == 0) {
                imgAirOut.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.image_checked
                    )
                )
                1
            } else {
                imgAirOut.setImageDrawable(null)
                0
            }
        }

        linearFeedMalt.setOnClickListener {
            checked5 = if (checked5 == 0) {
                imgFeedMalt.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.image_checked
                    )
                )
                1
            } else {
                imgFeedMalt.setImageDrawable(null)
                0
            }
        }

        linearSupplement.setOnClickListener {
            checked6 = if (checked6 == 0) {
                imgSupplement.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.image_checked
                    )
                )
                1
            } else {
                imgSupplement.setImageDrawable(null)
                0
            }
        }

        linearInspect.setOnClickListener {
            checked7 = if (checked7 == 0) {
                imgInspect.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.image_checked
                    )
                )
                1
            } else {
                imgInspect.setImageDrawable(null)
                0
            }
        }

        linearCleaning.setOnClickListener {
            checked8 = if (checked8 == 0) {
                imgCleaning.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.image_checked
                    )
                )
                1
            } else {
                imgCleaning.setImageDrawable(null)
                0
            }
        }

        linearTreat.setOnClickListener {
            checked9 = if (checked9 == 0) {
                imgTreat.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.image_checked
                    )
                )
                1
            } else {
                imgTreat.setImageDrawable(null)
                0
            }
        }

        linearMeds.setOnClickListener {
            checked10 = if (checked10 == 0) {
                imgMeds.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.image_checked
                    )
                )
                1
            } else {
                imgMeds.setImageDrawable(null)
                0
            }
        }

        linearVet.setOnClickListener {
            checked11 = if (checked11 == 0) {
                imgVet.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.image_checked
                    )
                )
                1
            } else {
                imgVet.setImageDrawable(null)
                0
            }
        }

        btnFillOut.setOnClickListener {
            finish()
        }

    }
}