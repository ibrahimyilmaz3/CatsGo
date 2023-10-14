package com.application.catsgo.ui.activity

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.application.catsgo.R
import com.application.catsgo.ui.dialog.*
import com.application.catsgo.service.Tools
import com.application.catsgo.util.BaseAppCompatActivity
import com.application.catsgo.util.EmailValidator
import kotlinx.android.synthetic.main.activity_user_profile_info.*
import kotlin.concurrent.fixedRateTimer


class UserProfileInfoActivity : BaseAppCompatActivity() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile_info)
        supportActionBar?.hide()
        Tools().appColorStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        ivBack.setOnClickListener {
            finish()
        }

        etPhoneNumber.addTextChangedListener(PhoneNumberFormattingTextWatcher("TR"))
        etPhoneNumber.setText("5555555555", TextView.BufferType.EDITABLE)

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

        linearDOB.setOnClickListener {
            val dobFragment = DOBFragment()
            dobFragment.show(supportFragmentManager, "dobFragment")
            dobFragment.result.observe(this) {
                tvDOB.text = it
                dobFragment.dismiss()
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

        linearOccupation.setOnClickListener {
            val occupationFragment = OccupationFragment()
            occupationFragment.show(supportFragmentManager, "occupationFragment")
            occupationFragment.result.observe(this) {
                tvOccupation.text = it
                occupationFragment.dismiss()
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
        etEmail.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearEmail.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
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

        btnGetLocation.setOnClickListener {
            etAddress.setText("...", TextView.BufferType.EDITABLE)
            fixedRateTimer("splash", false, 1000, 1000) {
                runOnUiThread {
                    etAddress.setText("Konum Bilgisi Alınamadı...", TextView.BufferType.EDITABLE)
                    this.cancel()
                }
            }
        }

        checkOther.isChecked = false
        linearOccupation.isClickable = true
        linearOccupation.setBackgroundResource(R.drawable.round_20_edittext_corner)
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

        btnUpdate.setOnClickListener {
            if (EmailValidator().isEmailValid(etEmail.text.toString())) {
                finish()
            } else {
                val invalidEmailFragment = InvalidEmailFragment()
                invalidEmailFragment.show(supportFragmentManager, "invalidEmailFragment")
                linearEmail.background =
                    ContextCompat.getDrawable(this, R.drawable.round_20_edittext_corner_red)
            }
        }

    }

    private fun clearFocus() {
        linearFullName.setBackgroundResource(R.drawable.round_20_edittext_corner)
        linearPhoneNumber.setBackgroundResource(R.drawable.round_20_edittext_corner)
        linearEmail.setBackgroundResource(R.drawable.round_20_edittext_corner)
        linearAddress.setBackgroundResource(R.drawable.round_20_edittext_corner)
        //linearStreet.setBackgroundResource(R.drawable.round_20_edittext_corner)
        //linearHousing.setBackgroundResource(R.drawable.round_20_edittext_corner)
        //linearBuildingNumber.setBackgroundResource(R.drawable.round_20_edittext_corner)
        //linearDoorNumber.setBackgroundResource(R.drawable.round_20_edittext_corner)
        //linearDOB.setBackgroundResource(R.drawable.round_20_edittext_corner)
        linearJob.setBackgroundResource(R.drawable.round_20_edittext_corner)
    }


}