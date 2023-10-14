package com.application.catsgo.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.MutableLiveData
import com.application.catsgo.R
import kotlinx.android.synthetic.main.dialog_cat_age.*
import kotlinx.android.synthetic.main.dialog_cat_age.view.*

class CatAgeFragment : DialogFragment() {

    //private val adapter = DialogCityRecyclerAdapter()
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
        val view = inflater.inflate(R.layout.dialog_cat_age, container, false)
        val window: Window? = dialog!!.window
        val wlp: WindowManager.LayoutParams = window!!.attributes
        wlp.gravity = Gravity.CENTER
        dialog!!.setCancelable(true)
        dialog!!.setCanceledOnTouchOutside(true)
        window.attributes = wlp

        /*view.rvDialog.adapter = adapter
        view.rvDialog.layoutManager = LinearLayoutManager(requireContext())*/
        /*adapter.result.observe(viewLifecycleOwner) {
            result.value = it
        }*/

        view.linearYear.setOnClickListener {
            val catYearFragment = CatYearFragment()
            catYearFragment.show(parentFragmentManager, "catYearFragment")
            catYearFragment.result.observe(this) {
                tvYear.text = it
                run(view)
            }
        }

        view.linearMonth.setOnClickListener {
            val catMonthFragment = CatMonthFragment()
            catMonthFragment.show(parentFragmentManager, "catMonthFragment")
            catMonthFragment.result.observe(this) {
                tvMonth.text = it
                run(view)
            }
        }



        return view
    }

    private fun run(view: View) {
        if (view.tvYear.text.toString().isNotBlank() && view.tvMonth.text.toString().isNotBlank()) {
            result.value = view.tvYear.text.toString() + " " + view.tvMonth.text.toString()
            dialog!!.dismiss()
        }
    }
}