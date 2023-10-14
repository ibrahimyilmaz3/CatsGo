package com.application.catsgo.ui.activity

import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.application.catsgo.R
import com.application.catsgo.ui.dialog.InvalidEmailFragment
import com.application.catsgo.service.Tools
import com.application.catsgo.util.BaseAppCompatActivity
import com.application.catsgo.util.EmailValidator
import com.application.catsgo.util.funIntent
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : BaseAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar?.hide()
        Tools().appColorStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        btnContinue.setOnClickListener {
            if (EmailValidator().isEmailValid(etEmail.text.toString())) {
                funIntent(CodeConfirmActivity())
            } else {
                val invalidEmailFragment = InvalidEmailFragment()
                invalidEmailFragment.show(supportFragmentManager, "invalidEmailFragment")
                linearEmail.background = ContextCompat.getDrawable(this,R.drawable.round_20_edittext_corner_red)
            }

        }

        etPhoneNumber.addTextChangedListener(PhoneNumberFormattingTextWatcher("TR"))

        linearMain.setOnClickListener {
            keyboardDown()
        }
        frameTop.setOnClickListener {
            keyboardDown()
        }

        //EDITTEXT onFOCUS COLOR CHANGE
        etFullName.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearFullName.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }
        /*etLastName.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearLastName.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }*/
        etPhoneNumber.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearPhone.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }
        etEmail.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearEmail.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }
    }

    private fun keyboardDown() {
        val imm: InputMethodManager =
            getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

    private fun clearFocus() {
        linearFullName.setBackgroundResource(R.drawable.round_20_edittext_corner)
        //linearLastName.setBackgroundResource(R.drawable.round_20_edittext_corner)
        linearPhone.setBackgroundResource(R.drawable.round_20_edittext_corner)
        linearEmail.setBackgroundResource(R.drawable.round_20_edittext_corner)
    }

}