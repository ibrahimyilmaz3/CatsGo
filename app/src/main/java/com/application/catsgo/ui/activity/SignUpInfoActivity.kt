package com.application.catsgo.ui.activity

import android.content.Context
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.application.catsgo.R
import com.application.catsgo.ui.dialog.*
import com.application.catsgo.service.Tools
import com.application.catsgo.util.BaseAppCompatActivity
import com.application.catsgo.util.MainNavigation
import com.application.catsgo.util.funIntent
import kotlinx.android.synthetic.main.activity_sign_up_info.*
import kotlin.concurrent.fixedRateTimer

class SignUpInfoActivity : BaseAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_info)
        supportActionBar?.hide()
        Tools().appColorStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        etPhoneNumber.addTextChangedListener(PhoneNumberFormattingTextWatcher("TR"))

        btnSignUp.setOnClickListener {
            if (MainNavigation.navigation == 1) {
                funIntent(ChooseActivity())
            }
            if (MainNavigation.navigation == 3) {
                funIntent(CreatePasswordActivity())
            }
        }

        mainConsProInfo.setOnClickListener {
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }

        linearCity.setOnClickListener {
            val cityFragment = CityFragment()
            cityFragment.show(supportFragmentManager, "cityFragment")
            cityFragment.result.observe(this) {
                tvCity.text = it
                cityFragment.dismiss()
            }
        }

        linearDistrict.setOnClickListener {
            val districtFragment = DistrictFragment()
            districtFragment.show(supportFragmentManager, "districtFragment")
            districtFragment.result.observe(this) {
                tvDistrict.text = it
                districtFragment.dismiss()
            }
        }

        linearGender.setOnClickListener {
            val genderFragment = GenderFragment()
            genderFragment.show(supportFragmentManager, "genderFragment")
            genderFragment.result.observe(this) {
                tvGender.text = it
                genderFragment.dismiss()
            }
        }

        linearEducation.setOnClickListener {
            val educationFragment = EducationFragment()
            educationFragment.show(supportFragmentManager, "educationFragment")
            educationFragment.result.observe(this) {
                tvEducation.text = it
                educationFragment.dismiss()
            }
        }

        linearDOB.setOnClickListener {
            /*val calendar: Calendar = Calendar.getInstance()
            val dialog = DatePickerDialog(this, { _, year, month, day_of_month ->
                calendar[Calendar.YEAR] = year
                calendar[Calendar.MONTH] = month + 1
                calendar[Calendar.DAY_OF_MONTH] = day_of_month
                val myFormat = "dd/MM/yyyy"
                val sdf = SimpleDateFormat(myFormat, Locale.getDefault())
                tvDOB.text = sdf.format(calendar.time)
            }, calendar[Calendar.YEAR], calendar[Calendar.MONTH], calendar[Calendar.DAY_OF_MONTH])
            dialog.datePicker.minDate = calendar.timeInMillis - 3153600000000
            calendar.add(Calendar.YEAR, 0)
            dialog.datePicker.maxDate = calendar.timeInMillis - 567648000000
            dialog.show()*/

            val dobFragment = DOBFragment()
            dobFragment.show(supportFragmentManager, "dobFragment")
            dobFragment.result.observe(this) {
                tvDOB.text = it
                dobFragment.dismiss()
            }
        }

        btnGetLocation.setOnClickListener {
            etAddress.setText("...", TextView.BufferType.EDITABLE)
            fixedRateTimer("splash", false, 1000, 1000) {
                runOnUiThread {
                    etAddress.setText("Konum Bilgisi Alınamadı...", TextView.BufferType.EDITABLE)
                    this.cancel()
                }
            }
        }

        etAddress.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearAddress.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }
        etJob.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearJob.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }
        etFullName.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearFullName.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }
        etPhoneNumber.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearPhoneNumber.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }
        etProx.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearProx.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }

        linearOccupation.setOnClickListener {
            val occupationFragment = OccupationFragment()
            occupationFragment.show(supportFragmentManager, "occupationFragment")
            occupationFragment.result.observe(this) {
                tvOccupation.text = it
                occupationFragment.dismiss()
            }
        }

        checkOther.isChecked = false
        linearOccupation.isClickable = true
        linearAddress.setBackgroundResource(R.drawable.round_20_edittext_corner)
        checkOther.setOnClickListener {
            if (checkOther.isChecked) {
                linearOccupation.isEnabled = false
                linearOccupation.isClickable = false
                linearOccupation.setBackgroundResource(R.drawable.round_20_edittext_corner_shadow)
                linearJob.visibility = View.VISIBLE
            } else {
                linearOccupation.isEnabled = true
                linearOccupation.isClickable = true
                linearOccupation.setBackgroundResource(R.drawable.round_20_edittext_corner)
                linearJob.visibility = View.GONE
            }
        }
    }

    override fun onBackPressed() {
        finish()
    }

    private fun clearFocus() {
        linearAddress.setBackgroundResource(R.drawable.round_20_edittext_corner)
        linearDOB.setBackgroundResource(R.drawable.round_20_edittext_corner)
        if (!checkOther.isChecked) {
            linearOccupation.setBackgroundResource(R.drawable.round_20_edittext_corner)
        }
        linearJob.setBackgroundResource(R.drawable.round_20_edittext_corner)
        linearFullName.setBackgroundResource(R.drawable.round_20_edittext_corner)
        linearPhoneNumber.setBackgroundResource(R.drawable.round_20_edittext_corner)
        linearProx.setBackgroundResource(R.drawable.round_20_edittext_corner)
    }

}