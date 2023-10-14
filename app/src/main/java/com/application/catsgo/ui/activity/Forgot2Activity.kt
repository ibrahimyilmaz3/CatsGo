package com.application.catsgo.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.widget.addTextChangedListener
import com.application.catsgo.R
import com.application.catsgo.service.Tools
import com.application.catsgo.util.BaseAppCompatActivity
import com.application.catsgo.util.funIntent
import kotlinx.android.synthetic.main.activity_code_confirm.*

class Forgot2Activity : BaseAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot2)
        supportActionBar?.hide()
        Tools().appColorStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        btnConfirmCode.setOnClickListener {
            funIntent(Forgot3Activity())
        }

        etConfirmInput.addTextChangedListener {
            when (etConfirmInput.text.toString().length) {
                0 -> {
                    tvFirstBox.text = ""
                    tvSecondBox.text = ""
                    tvThirdBox.text = ""
                    tvFourthBox.text = ""
                    clearFocus()
                }
                1 -> {
                    tvFirstBox.text = etConfirmInput.text.toString().substring(0, 1)
                    tvSecondBox.text = ""
                    tvThirdBox.text = ""
                    tvFourthBox.text = ""
                    clearFocus()
                    tvFirstBox.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
                }
                2 -> {
                    tvSecondBox.text = etConfirmInput.text.toString().substring(1, 2)
                    tvThirdBox.text = ""
                    tvFourthBox.text = ""
                    clearFocus()
                    tvSecondBox.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
                }
                3 -> {
                    tvThirdBox.text = etConfirmInput.text.toString().substring(2, 3)
                    tvFourthBox.text = ""
                    clearFocus()
                    tvThirdBox.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
                }
                4 -> {
                    tvFourthBox.text = etConfirmInput.text.toString().substring(3, 4)
                    clearFocus()
                    tvFourthBox.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
                }
            }
        }
    }

    private fun clearFocus() {
        tvFirstBox.setBackgroundResource(R.drawable.round_20_edittext_corner)
        tvSecondBox.setBackgroundResource(R.drawable.round_20_edittext_corner)
        tvThirdBox.setBackgroundResource(R.drawable.round_20_edittext_corner)
        tvFourthBox.setBackgroundResource(R.drawable.round_20_edittext_corner)
    }

}