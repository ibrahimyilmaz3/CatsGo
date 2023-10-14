package com.application.catsgo.ui.dialog

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.MutableLiveData
import com.application.catsgo.R
import com.application.catsgo.adapter.DialogVicinityRecyclerAdapter
import kotlinx.android.synthetic.main.dialog_sign_up_success.view.*

class ConfirmFragment : DialogFragment() {

    private val adapter = DialogVicinityRecyclerAdapter()
    val result = MutableLiveData<String>()
    private var navigationSelected: Int? = null

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.9).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val view = inflater.inflate(R.layout.dialog_sign_up_success, container, false)
        val window: Window? = dialog!!.window
        val wlp: WindowManager.LayoutParams = window!!.attributes
        wlp.gravity = Gravity.CENTER
        dialog!!.setCancelable(false)
        dialog!!.setCanceledOnTouchOutside(false)
        window.attributes = wlp

        view.tvHeadingDialog.text = "Kediniz başarıyla silindi!"
        view.btnContinue.setOnClickListener {
            (context as AppCompatActivity).finish()
            /*
            //Dismiss all dialog fragments
            requireActivity().supportFragmentManager.fragments.takeIf { it.isNotEmpty() }
                ?.map { (it as? DialogFragment)?.dismiss() }*/
        }

        return view
    }

    fun funClearIntent(activity: Activity) {
        val intent = Intent(context, activity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

}