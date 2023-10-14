package com.application.catsgo.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.MutableLiveData
import com.application.catsgo.R
import com.application.catsgo.service.Calendar1
import kotlinx.android.synthetic.main.dialog_dob.view.*

class DOBFragment : DialogFragment() {

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
        val view = inflater.inflate(R.layout.dialog_dob, container, false)
        val window: Window? = dialog!!.window
        val wlp: WindowManager.LayoutParams = window!!.attributes
        wlp.gravity = Gravity.CENTER
        dialog!!.setCancelable(true)
        dialog!!.setCanceledOnTouchOutside(true)
        window.attributes = wlp

        //DatePicker
        Calendar1(context as AppCompatActivity, view.calendar_recyclerView, view.header, view.nextB, view.previousB).result.observe(viewLifecycleOwner){
            result.value = it
        }

        view.tvHeadingDialog.text = "Doğum Tarihiniz"
        //view.rvDialog.adapter = adapter
        //view.rvDialog.layoutManager = LinearLayoutManager(requireContext())
        return view
    }
}