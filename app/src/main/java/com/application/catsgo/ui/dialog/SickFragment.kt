package com.application.catsgo.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.MutableLiveData
import com.application.catsgo.R
import kotlinx.android.synthetic.main.dialog_allergy.view.*

class SickFragment : DialogFragment() {

    val result = MutableLiveData<String>()

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
        val view = inflater.inflate(R.layout.dialog_allergy, container, false)
        val window: Window? = dialog!!.window
        val wlp: WindowManager.LayoutParams = window!!.attributes
        wlp.gravity = Gravity.CENTER
        dialog!!.setCancelable(false)
        dialog!!.setCanceledOnTouchOutside(false)
        window.attributes = wlp

        view.tvHeadingDialog.text = "Kronik Rahatsızlık"
        view.tvAllergy.hint = "Kronik Rahatsızlık"

        view.linearAllergy.setOnClickListener {
            val sick2Fragment = Sick2Fragment()
            sick2Fragment.show(parentFragmentManager, "sick2Fragment")
            sick2Fragment.result.observe(this) {
                view.tvAllergy.text = it
                if (view.tvAllergy.text.toString() == "Evet") {
                    view.etExplain.isEnabled = true
                    view.etExplain.isClickable = true
                    view.linearExplain.background = ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.round_20_edittext_corner
                    )
                } else {
                    view.etExplain.isEnabled = false
                    view.etExplain.isClickable = false
                    view.linearExplain.background = ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.round_20_edittext_corner_shadow
                    )
                }
            }
            view.btnContinue.setOnClickListener {
                if (view.tvAllergy.text.toString() == "Evet") {
                    result.value = view.etExplain.text.toString()
                } else {
                    result.value = view.tvAllergy.text.toString()
                }
            }
        }
        return view
    }
}