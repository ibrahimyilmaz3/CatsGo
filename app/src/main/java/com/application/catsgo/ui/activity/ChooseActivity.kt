package com.application.catsgo.ui.activity


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import com.application.catsgo.R
import com.application.catsgo.ui.dialog.VetFragment
import com.application.catsgo.service.Tools
import com.application.catsgo.util.BaseAppCompatActivity
import com.application.catsgo.util.funIntent
import kotlinx.android.synthetic.main.activity_choose.*

class ChooseActivity : BaseAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)
        supportActionBar?.hide()
        Tools().appColorStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        btnContinue.setOnClickListener {
            funIntent(CreatePasswordActivity())
        }

        linearVet.setOnClickListener {
            val vetFragment = VetFragment()
            vetFragment.show(supportFragmentManager, "vetFragment")
            vetFragment.result.observe(this) {
                tvVet.text = it
                vetFragment.dismiss()
            }
        }

        check.isChecked = false
        linearVet.isClickable = true
        linearAddress.setBackgroundResource(R.drawable.round_20_edittext_corner)
        check.setOnClickListener {
            if (check.isChecked) {
                linearVet.isEnabled = false
                linearVet.isClickable = false
                linearVet.setBackgroundResource(R.drawable.round_20_edittext_corner_shadow)
                linearAddress.visibility = View.VISIBLE
                linearName.visibility = View.VISIBLE
            } else {
                linearVet.isEnabled = true
                linearVet.isClickable = true
                linearVet.setBackgroundResource(R.drawable.round_20_edittext_corner)
                linearAddress.visibility = View.GONE
                linearName.visibility = View.GONE
            }
        }

        etName.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearName.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }

        etAddress.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearAddress.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }

    }

    private fun clearFocus() {
        linearAddress.setBackgroundResource(R.drawable.round_20_edittext_corner)
        linearName.setBackgroundResource(R.drawable.round_20_edittext_corner)
    }

}