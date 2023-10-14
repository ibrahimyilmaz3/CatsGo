package com.application.catsgo.ui.activity

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.application.catsgo.R
import com.application.catsgo.ui.dialog.ChangeFragment
import com.application.catsgo.service.Tools
import com.application.catsgo.util.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_user_change_password.*

class UserChangePasswordActivity : BaseAppCompatActivity() {

    private var selected1 = 0
    private var selected2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_change_password)
        supportActionBar?.hide()
        Tools().appColorStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        ivBack.setOnClickListener {
            finish()
        }

        btnChangePassword.setOnClickListener {
            if (etOld.text.length < 8) {
                etOld.error = "Şifreniz minimum 8 karakter olmalıdır!"
            } else if (etNew.text.length < 8) {
                etNew.error = "Şifreniz minimum 8 karakter olmalıdır!"
            } else if (etAgain.text.toString() != etNew.text.toString()) {
                etAgain.error = "Girdiğiniz şifreler uyuşmuyor!"
                etNew.error = "Girdiğiniz şifreler uyuşmuyor!"
            } else if (etAgain.text.toString() == etOld.text.toString()) {
                etAgain.error = "Girdiğiniz şifre eski şifrenizle aynı!"
                etNew.error = "Girdiğiniz şifre eski şifrenizle aynı!"
            } else if (!noSequenzes(etNew.text.toString())) {
                etNew.error = "Şifreniz ardışık karakterler içermemelidir."
            } else if (hasRepetitiveChars(etAgain.text.toString())) {
                etAgain.error = "Şifreniz yineleme içermemelidir"
            } else {
                val changeFragment = ChangeFragment()
                changeFragment.show(supportFragmentManager, "changeFragment")
            }
        }

        ivToggle1.setOnClickListener {
            if (selected1 == 0) {
                etOld.transformationMethod = HideReturnsTransformationMethod.getInstance()
                selected1 = 1
                ivToggle1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.eye_hide))
            } else {
                etOld.transformationMethod = PasswordTransformationMethod.getInstance()
                selected1 = 0
                ivToggle1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.eye_show))
            }
        }
        ivToggle2.setOnClickListener {
            if (selected2 == 0) {
                etNew.transformationMethod = HideReturnsTransformationMethod.getInstance()
                selected2 = 1
                ivToggle2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.eye_hide))
            } else {
                etNew.transformationMethod = PasswordTransformationMethod.getInstance()
                selected2 = 0
                ivToggle2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.eye_show))
            }
        }
        ivToggle3.setOnClickListener {
            if (selected2 == 0) {
                etAgain.transformationMethod = HideReturnsTransformationMethod.getInstance()
                selected2 = 1
                ivToggle3.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.eye_hide))
            } else {
                etAgain.transformationMethod = PasswordTransformationMethod.getInstance()
                selected2 = 0
                ivToggle3.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.eye_show))
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