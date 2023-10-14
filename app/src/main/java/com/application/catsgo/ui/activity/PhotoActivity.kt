package com.application.catsgo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.application.catsgo.R
import com.application.catsgo.service.Tools
import kotlinx.android.synthetic.main.activity_photo.*

class PhotoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)
        Tools().appColorStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        linearClose.setOnClickListener {
            finish()
        }

        var myValue = intent.getStringExtra("id")
        if (myValue != null) {
            tvJob.text = myValue
            when (myValue) {
                "Mama verildi" -> {
                    ivPhoto.setImageDrawable(
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.cat_food_example
                        )
                    )
                }
                "Su verildi" -> {
                    ivPhoto.setImageDrawable(
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.cat_water_example
                        )
                    )
                }
                "Veteriner taraması yapıldı" -> {
                    ivPhoto.setImageDrawable(
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.cat_vet_example
                        )
                    )
                }
                "Tuvalet temizlendi" -> {
                    ivPhoto.setImageDrawable(
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.cat_litter_example
                        )
                    )
                }
            }
        } else {
            myValue = "Resim bulunamadı!"

        }


    }
}