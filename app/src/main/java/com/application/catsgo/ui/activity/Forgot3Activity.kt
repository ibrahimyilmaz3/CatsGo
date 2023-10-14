package com.application.catsgo.ui.activity

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.application.catsgo.R
import com.application.catsgo.ui.dialog.ForgotFragment
import com.application.catsgo.service.Tools
import com.application.catsgo.util.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_forgot3.*

class Forgot3Activity : BaseAppCompatActivity() {

    private var selected1 = 0
    private var selected2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot3)
        supportActionBar?.hide()
        Tools().appColorStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        btnCreatePassword.setOnClickListener {
            if (etPassword1.text.length < 8) {
                etPassword1.error = "Şifreniz minimum 8 karakter olmalıdır."
            } else if (etPassword1.text.length < 8) {
                etPassword1.error = "Şifreniz minimum 8 karakter olmalıdır."
            } else if (etPassword1.text.toString() != etPassword2.text.toString()) {
                etPassword1.error = "Girdiğiniz şifreler uyuşmuyor."
                etPassword2.error = "Girdiğiniz şifreler uyuşmuyor."
            } else if (!noSequenzes(etPassword1.text.toString())) {
                etPassword1.error = "Şifreniz ardışık karakterler içermemelidir."
            } else if (hasRepetitiveChars(etPassword2.text.toString())) {
                etPassword1.error = "Şifreniz yineleme içermemelidir"
            } else {
                val forgotFragment = ForgotFragment()
                forgotFragment.show(supportFragmentManager, "forgotFragment")
            }
        }

        ivToggle1.setOnClickListener {
            if (selected1 == 0) {
                etPassword1.transformationMethod = HideReturnsTransformationMethod.getInstance()
                selected1 = 1
                ivToggle1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.eye_hide))
            } else {
                etPassword1.transformationMethod = PasswordTransformationMethod.getInstance()
                selected1 = 0
                ivToggle1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.eye_show))
            }
        }
        ivToggle2.setOnClickListener {
            if (selected2 == 0) {
                etPassword2.transformationMethod = HideReturnsTransformationMethod.getInstance()
                selected2 = 1
                ivToggle2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.eye_hide))
            } else {
                etPassword2.transformationMethod = PasswordTransformationMethod.getInstance()
                selected2 = 0
                ivToggle2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.eye_show))
            }
        }

    }

    private fun hasRepetitiveChars(str: String): Boolean {
        for (i in 0 until str.length - 1) {
            if (str[i] == str[i + 1]) {
                return true
            }
        }
        return false
    }

    private fun noSequenzes(password: String): Boolean {
        val charRuns = listOf(
            '0'..'9',
            'a'..'z',
            'A'..'Z',
            "qwertzuiop".asIterable(),
            "asdfghjklöä".asIterable(),
            "yxcvbnm".asIterable()
        )
        var map = emptyMap<Char, MutableSet<Char?>>()
        charRuns.forEach { run ->
            run.forEach { char ->
                val charsToAdd = mutableSetOf(run.elementAtOrNull(run.indexOf(char) + 1))
                if (run is CharRange) {
                    charsToAdd.add(run.elementAtOrNull(run.indexOf(char) - 1))
                }
                if (map.contains(char)) {
                    map.get(char)!!.addAll(charsToAdd)
                } else {
                    map = map.plus(Pair(char, charsToAdd))
                }
            }
        }
        var sequenceCounter = 1
        var recentChar: Char? = null
        password.toCharArray().forEach { c ->
            recentChar?.let { rc ->
                val isSequence = map.any { me -> me.key == rc && me.value.contains(c) }
                if (isSequence) {
                    sequenceCounter = sequenceCounter + 1
                } else {
                    sequenceCounter = 1
                }
                if (sequenceCounter >= 3) {
                    return false
                }
            }
            recentChar = c
        }
        return true
    }

}