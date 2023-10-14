package com.application.catsgo.ui.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.text.Spannable
import android.text.SpannableString
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.text.style.UnderlineSpan
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.application.catsgo.R
import com.application.catsgo.service.Tools
import com.application.catsgo.util.BaseAppCompatActivity
import com.application.catsgo.util.MainNavigation
import com.application.catsgo.util.funIntent
import kotlinx.android.synthetic.main.activity_main_login.*

class MainLoginActivity : BaseAppCompatActivity() {

    private var selected = 1
    private var selected1 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)
        supportActionBar?.hide()
        Tools().appColorStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        etPhoneNumber.addTextChangedListener(PhoneNumberFormattingTextWatcher("TR"))

        linearCustomerLogin.setBackgroundResource(R.drawable.round_20_shadow_bottom_blue_10)
        linearCustomerLogin.setOnClickListener {
            linearCustomerLogin.setBackgroundResource(R.drawable.round_20_shadow_bottom_blue_10)
            linearVetLogin.setBackgroundResource(R.drawable.round_20_shadow_bottom_10)
            linearCatsGoLogin.setBackgroundResource(R.drawable.round_20_shadow_bottom_10)
            btnSignUp.visibility = View.VISIBLE
            selected = 1
        }

        linearVetLogin.setOnClickListener {
            linearCustomerLogin.setBackgroundResource(R.drawable.round_20_shadow_bottom_10)
            linearVetLogin.setBackgroundResource(R.drawable.round_20_shadow_bottom_blue_10)
            linearCatsGoLogin.setBackgroundResource(R.drawable.round_20_shadow_bottom_10)
            btnSignUp.visibility = View.INVISIBLE
            selected = 2
        }

        linearCatsGoLogin.setOnClickListener {
            linearCustomerLogin.setBackgroundResource(R.drawable.round_20_shadow_bottom_10)
            linearVetLogin.setBackgroundResource(R.drawable.round_20_shadow_bottom_10)
            linearCatsGoLogin.setBackgroundResource(R.drawable.round_20_shadow_bottom_blue_10)
            btnSignUp.visibility = View.VISIBLE
            selected = 3
        }

        btnLogin.setOnClickListener {
            when (selected) {
                1 -> funIntent(UserMainActivity())
                2 -> funIntent(VetMainActivity())
                3 -> funIntent(MainActivity())
            }
        }

        btnSignUp.setOnClickListener {
            funIntent(SignUpActivity())
            MainNavigation.navigation = selected
        }

        etPhoneNumber.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearPhoneNumber.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }
        etPassword.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearPassword.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }

        mainLinear.setOnClickListener {
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }

        val spannable = SpannableString("Kullanıcı sözleşmesini okudum ve kabul ediyorum.")
        spannable.setSpan(
            UnderlineSpan(),
            0,
            22,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tvTerm.text = spannable

        linearTerm.setOnClickListener {
            val i = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.wookweb.com/gizlilik-sozlesmesi/")
            )
            startActivity(i)
        }

        btnForgot.setOnClickListener {
            funIntent(Forgot1Activity())
        }

        ivToggle.setOnClickListener {
            if (selected1 == 0) {
                etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                selected1 = 1
                ivToggle.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.eye_hide))
            } else {
                etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                selected1 = 0
                ivToggle.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.eye_show))
            }
        }

    }

    override fun onBackPressed() {

    }

    private fun clearFocus() {

        linearPhoneNumber.setBackgroundResource(R.drawable.round_20_edittext_corner)
        linearPassword.setBackgroundResource(R.drawable.round_20_edittext_corner)

    }

}