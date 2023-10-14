package com.application.catsgo.ui.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.application.catsgo.R
import com.application.catsgo.service.Tools
import com.application.catsgo.util.funIntent
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.activity_account.imgAccount
import kotlinx.android.synthetic.main.activity_account.imgMessages
import kotlinx.android.synthetic.main.activity_account.linearAccount
import kotlinx.android.synthetic.main.activity_account.linearBottom
import kotlinx.android.synthetic.main.activity_account.linearHome
import kotlinx.android.synthetic.main.activity_account.linearMessages
import kotlinx.android.synthetic.main.activity_account.tvAccount
import kotlinx.android.synthetic.main.activity_account.tvHome
import kotlinx.android.synthetic.main.activity_account.tvMessages

@Suppress("DEPRECATION")
class AccountActivity : AppCompatActivity() {

    private val pickImage = 100
    private var imageUri: Uri? = null

    private val REQUEST_IMAGE_CAPTURE = 1
    private val CAMERA_PERMISSION_CODE = 1
    private val REQUEST_CODE_PERMISSION_GALLERY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        supportActionBar?.hide()
        Tools().appColorStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        tvAccount.setTextColor(resources.getColor(R.color.bottom_menu_text_clicked))
        imgAccount.setImageResource(R.drawable.profile_after_click)
        bottomMenu()

        linearProfileInfo.setOnClickListener {
            val intent = Intent(this, ProfileInfoActivity::class.java)
            startActivity(intent)
        }
        linearCatsUnderMyCare.setOnClickListener {
            val intent = Intent(this, CatsCaredForActivity::class.java)
            startActivity(intent)
        }

        relativePickImage.setOnClickListener {
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

        linearChangePassword.setOnClickListener {
            val intent = Intent(this, ChangePasswordActivity::class.java)
            startActivity(intent)
        }
        linearAbout.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.wookweb.com/hizmetler/"))
            startActivity(i)
        }
        linearTerms.setOnClickListener {
            val i = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.wookweb.com/gizlilik-sozlesmesi/")
            )
            startActivity(i)
        }

        linearExit.setOnClickListener {
            funIntent(MainLoginActivity())
        }

        linearBottom.setOnClickListener {  }

    }

    override fun onBackPressed() {
    }

    private fun bottomMenu() {
        linearHome.setOnClickListener {

            //val intent = Intent(this, MainActivity::class.java)
            //startActivity(intent)
            this.startActivity(
                Intent(
                    this,
                    MainActivity::class.java
                ).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            )


            tvHome.setTextColor(resources.getColor(R.color.bottom_menu_text_clicked))
            imgHome.setImageResource(R.drawable.pet_after_click)

            tvMessages.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgMessages.setImageResource(R.drawable.sms_before_click)

            tvAccount.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgAccount.setImageResource(R.drawable.profile_before_click)

        }
        linearMessages.setOnClickListener {

            //val intent = Intent(this, MessagesActivity::class.java)
            //startActivity(intent)
            this.startActivity(
                Intent(
                    this,
                    MessagesActivity::class.java
                ).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            )


            tvHome.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgHome.setImageResource(R.drawable.pet_before_click)

            tvMessages.setTextColor(resources.getColor(R.color.bottom_menu_text_clicked))
            imgMessages.setImageResource(R.drawable.sms_after_click)

            tvAccount.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgAccount.setImageResource(R.drawable.profile_before_click)

        }
        linearAccount.setOnClickListener {

            tvHome.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgHome.setImageResource(R.drawable.pet_before_click)

            tvMessages.setTextColor(resources.getColor(R.color.bottom_menu_text))
            imgMessages.setImageResource(R.drawable.sms_before_click)

            tvAccount.setTextColor(resources.getColor(R.color.bottom_menu_text_clicked))
            imgAccount.setImageResource(R.drawable.profile_after_click)

        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            ivProPic.setImageURI(imageUri)
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