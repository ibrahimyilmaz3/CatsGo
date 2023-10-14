package com.application.catsgo.ui.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.application.catsgo.R
import com.application.catsgo.service.Tools
import com.application.catsgo.util.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_clinic.*

class ClinicActivity : BaseAppCompatActivity() {

    private var previousText = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clinic)
        supportActionBar?.hide()
        Tools().appColorStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        fin()
        tab()
        keyboardDown()
        focus()

        etIBAN.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {
                etIBAN.removeTextChangedListener(this)

                val formattedText = formatInput(s.toString())
                etIBAN.setText(formattedText)
                etIBAN.setSelection(formattedText.length)

                etIBAN.addTextChangedListener(this)
            }
        })

    }

    private fun formatInput(input: String): String {
        val cleanInput = input.replace(" ", "")
        val sb = StringBuilder()

        for ((index, char) in cleanInput.withIndex()) {
            if (index == 2) {
                sb.append(char)
                sb.append(" ")
            } else if (index == 6 || index == 10 || index == 14) {
                sb.append(" ")
                sb.append(char)
            } else {
                sb.append(char)
            }
        }

        return sb.toString()
    }

    private fun fin() {
        linearBack.setOnClickListener {
            finish()
        }

        btnConfirm.setOnClickListener {
            finish()
        }
    }

    private fun tab() {
        tvAll.setTextColor(
            ContextCompat.getColor(
                this,
                R.color.bottom_menu_text_clicked
            )
        )

        linearAll.setOnClickListener {
            tvAll.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.bottom_menu_text_clicked
                )
            )
            tvUnread.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.color_717171
                )
            )
            linIBAN.visibility = View.VISIBLE
            linearAccount.visibility = View.GONE
        }

        linearUnread.setOnClickListener {
            tvAll.setTextColor(ContextCompat.getColor(this, R.color.color_717171))
            tvUnread.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.bottom_menu_text_clicked
                )
            )
            linIBAN.visibility = View.GONE
            linearAccount.visibility = View.VISIBLE
        }
    }

    private fun keyboardDown() {
        mainLinear.setOnClickListener {
            val imm: InputMethodManager =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }

    private fun focus() {
        etIBAN.setOnFocusChangeListener { view, b ->
            run {
                clear()
                linearIBAN.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }
        etName1.setOnFocusChangeListener { view, b ->
            run {
                clear()
                linearName1.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }
        etNumber.setOnFocusChangeListener { view, b ->
            run {
                clear()
                linearNumber.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }
        etBranch.setOnFocusChangeListener { view, b ->
            run {
                clear()
                linearBranch.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }
        etName2.setOnFocusChangeListener { view, b ->
            run {
                clear()
                linearName2.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }
    }

    private fun clear() {
        linearIBAN.setBackgroundResource(R.drawable.round_20_edittext_corner)
        linearName1.setBackgroundResource(R.drawable.round_20_edittext_corner)
        linearNumber.setBackgroundResource(R.drawable.round_20_edittext_corner)
        linearBranch.setBackgroundResource(R.drawable.round_20_edittext_corner)
        linearName2.setBackgroundResource(R.drawable.round_20_edittext_corner)
    }

}