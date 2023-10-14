package com.application.catsgo.ui.activity

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.application.catsgo.R
import com.application.catsgo.service.Tools
import com.application.catsgo.util.funIntent
import kotlinx.android.synthetic.main.activity_user_cats_under_care.*

class UserCatsUnderCareActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_cats_under_care)
        Tools().appColorStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        click()
        span()
        photo()

    }

    private fun photo() {
        linearFood.setOnClickListener {
            val intent = Intent(this, PhotoActivity()::class.java)
            intent.putExtra("id","Mama verildi")
            startActivity(intent)
        }
        linearWater.setOnClickListener {
            val intent = Intent(this, PhotoActivity()::class.java)
            intent.putExtra("id","Su verildi")
            startActivity(intent)
        }
        linearCheckUp.setOnClickListener {
            val intent = Intent(this, PhotoActivity()::class.java)
            intent.putExtra("id","Veteriner taraması yapıldı")
            startActivity(intent)
        }
        linearClean.setOnClickListener {
            val intent = Intent(this, PhotoActivity()::class.java)
            intent.putExtra("id","Tuvalet temizlendi")
            startActivity(intent)
        }
    }

    private fun span() {
        val spannable = SpannableString("Bakımın 2. Günü (1 Gün Kaldı)")
        spannable.setSpan(
            StyleSpan(Typeface.BOLD),
            8,
            10,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )

        tvCare.text = spannable
    }

    private fun click() {
        ivBack.setOnClickListener {
            funIntent(UserMyRequestsActivity())
        }

        linearCamera.setOnClickListener {
            val intent = Intent(this, UserCameraActivity::class.java)
            startActivity(intent)
        }

        linearRateService.setOnClickListener {
            val intent = Intent(this, UserRateServiceActivity::class.java)
            startActivity(intent)
        }

        linearSendMessage.setOnClickListener {
            val intent = Intent(this, UserMessageContentActivity::class.java)
            startActivity(intent)
        }
    }
}