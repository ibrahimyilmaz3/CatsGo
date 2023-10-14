package com.application.catsgo.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseAppCompatActivity : AppCompatActivity() {

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val imm: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        return true
    }
}

fun AppCompatActivity.funIntent(activity: Activity) {
    val intent = Intent(applicationContext, activity::class.java)
    startActivity(intent)
}
fun AppCompatActivity.funClearIntent(activity: Activity) {
    val intent = Intent(applicationContext, activity::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(intent)
}

fun AppCompatActivity.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()