package com.application.catsgo.ui.activity

import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import androidx.appcompat.app.AppCompatDelegate
import com.application.catsgo.R
import com.application.catsgo.service.Tools
import com.application.catsgo.util.BaseAppCompatActivity
import com.application.catsgo.util.funIntent
import kotlinx.android.synthetic.main.activity_forgot1.*

class Forgot1Activity : BaseAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot1)
        supportActionBar?.hide()
        Tools().appColorStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        etPhoneNumber.addTextChangedListener(PhoneNumberFormattingTextWatcher("TR"))

        btnContinue.setOnClickListener {
            funIntent(Forgot2Activity())
        }

        etPhoneNumber.setOnFocusChangeListener { view, b ->
            run {
                linearPhone.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }

    }
}