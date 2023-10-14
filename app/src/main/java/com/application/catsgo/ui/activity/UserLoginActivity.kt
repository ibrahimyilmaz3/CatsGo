package com.application.catsgo.ui.activity

import android.content.Intent
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import androidx.appcompat.app.AppCompatDelegate
import com.application.catsgo.R
import com.application.catsgo.service.Tools
import com.application.catsgo.util.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_user_login.*
import kotlinx.android.synthetic.main.activity_user_login.btnContinue
import kotlinx.android.synthetic.main.activity_user_login.etPhoneNumber

class UserLoginActivity : BaseAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)
        supportActionBar?.hide()
        Tools().appColorStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        btnContinue.setOnClickListener {
            val intent = Intent(this, UserMainActivity::class.java)
            startActivity(intent)
        }

        etPhoneNumber.addTextChangedListener(PhoneNumberFormattingTextWatcher("TR"))
        etPhoneNumber.setOnFocusChangeListener { view, b ->
            run {
                linearPhoneNumber.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }

    }
}