package com.application.catsgo.ui.activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.application.catsgo.R
import com.application.catsgo.ui.dialog.*
import com.application.catsgo.service.Tools
import com.application.catsgo.util.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_user_update_cat_info.*

class UserUpdateCatInfoActivity : BaseAppCompatActivity() {

    private val pickImage = 100
    private var imageUri: Uri? = null

    private val REQUEST_IMAGE_CAPTURE = 1
    private val CAMERA_PERMISSION_CODE = 1
    private val REQUEST_CODE_PERMISSION_GALLERY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_update_cat_info)
        Tools().appColorStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        mainLinear.setOnClickListener {
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }

        ivBack.setOnClickListener {
            finish()
        }

        btnUpdate.setOnClickListener {
            finish()
        }

        checkAddress.isChecked = false
        etAddress.isEnabled = true
        etAddress.isClickable = true
        linearAddress.setBackgroundResource(R.drawable.round_20_edittext_corner)
        checkAddress.setOnClickListener {
            if (checkAddress.isChecked) {
                etAddress.isEnabled = false
                etAddress.isClickable = false
                linearAddress.setBackgroundResource(R.drawable.round_20_edittext_corner_shadow)
            } else {
                etAddress.isEnabled = true
                etAddress.isClickable = true
                linearAddress.setBackgroundResource(R.drawable.round_20_edittext_corner)
            }
        }

        linearAge.setOnClickListener {
            val catAgeFragment = CatAgeFragment()
            catAgeFragment.show(supportFragmentManager, "catAgeFragment")
            catAgeFragment.result.observe(this) {
                tvAge.text = it
            }
        }

        tvGender.setOnClickListener {
            val catGenderFragment = CatGenderFragment()
            catGenderFragment.show(supportFragmentManager, "catGenderFragment")
            catGenderFragment.result.observe(this) {
                tvGender.text = it
            }
        }
        tvWeight.setOnClickListener {
            val catWeightFragment = CatWeightFragment()
            catWeightFragment.show(supportFragmentManager, "catWeightFragment")
            catWeightFragment.result.observe(this) {
                tvWeight.text = it
            }
        }
        tvAggression.setOnClickListener {
            val catAggressionFragment = CatAggressionFragment()
            catAggressionFragment.show(supportFragmentManager, "catAggressionFragment")
            catAggressionFragment.result.observe(this) {
                tvAggression.text = it
            }
        }

        etNote.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearNote.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }
        etAddress.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearAddress.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }
        etName.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearName.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }
        etVetAddress.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearVetAddress.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }

        conImage.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // Request permission to read external storage
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    REQUEST_CODE_PERMISSION_GALLERY
                )
            } else {
                openGallery()
            }
        }

        btnDelete.setOnClickListener {
            val deleteFragment = DeleteFragment()
            deleteFragment.show(supportFragmentManager, "deleteFragment")
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
        linearVetAddress.setBackgroundResource(R.drawable.round_20_edittext_corner)
        check.setOnClickListener {
            if (check.isChecked) {
                linearVet.isEnabled = false
                linearVet.isClickable = false
                linearVet.setBackgroundResource(R.drawable.round_20_edittext_corner_shadow)
                linearVetAddress.visibility = View.VISIBLE
                linearName.visibility = View.VISIBLE
            } else {
                linearVet.isEnabled = true
                linearVet.isClickable = true
                linearVet.setBackgroundResource(R.drawable.round_20_edittext_corner)
                linearVetAddress.visibility = View.GONE
                linearName.visibility = View.GONE
            }
        }

        etName.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearName.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }

        etVetAddress.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearVetAddress.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }

        tvAllergy.setOnClickListener {
            val allergyFragment = AllergyFragment()
            allergyFragment.show(supportFragmentManager, "allergyFragment")
            allergyFragment.result.observe(this) {
                tvAllergy.text = it
                allergyFragment.dismiss()
            }
        }

        tvSick.setOnClickListener {
            val sickFragment = SickFragment()
            sickFragment.show(supportFragmentManager, "sickFragment")
            sickFragment.result.observe(this) {
                tvSick.text = it
                sickFragment.dismiss()
            }
        }

        tvVaccine.setOnClickListener {
            val vaccineFragment = VaccineFragment()
            vaccineFragment.show(supportFragmentManager, "vaccineFragment")
            vaccineFragment.result.observe(this) {
                tvVaccine.text = it
                vaccineFragment.dismiss()
            }
        }

        tvWater.setOnClickListener {
            val waterFragment = WaterFragment()
            waterFragment.show(supportFragmentManager, "waterFragment")
            waterFragment.result.observe(this) {
                tvWater.text = it
            }
        }

    }

    private fun clearFocus() {
        linearNote.setBackgroundResource(R.drawable.round_20_edittext_corner)
        if (!checkAddress.isChecked) {
            linearAddress.setBackgroundResource(R.drawable.round_20_edittext_corner)
        }
        linearName.setBackgroundResource(R.drawable.round_20_edittext_corner)
        linearVetAddress.setBackgroundResource(R.drawable.round_20_edittext_corner)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            ivCat.setImageURI(imageUri)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                dispatchTakePictureIntent()
            } else {
                // Permission denied, show error message or disable camera functionality
            }
        }
        when (requestCode) {
            REQUEST_CODE_PERMISSION_GALLERY -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission is granted, access the gallery
                    openGallery()
                } else {
                    // Permission is denied, show a message or take appropriate action
                }
            }
        }
    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }
    }

    private fun openGallery() {
        val gallery = Intent(
            android.content.Intent.ACTION_PICK,
            android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI
        )
        startActivityForResult(gallery, pickImage)
    }

}