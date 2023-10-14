package com.application.catsgo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.fragment_bottom_sheet_announce.*
import kotlinx.android.synthetic.main.item_appointments.view.*


class VetAppointmentsRecyclerAdapter :
    RecyclerView.Adapter<VetAppointmentsRecyclerAdapter.ViewHolder>() {

    private lateinit var context: Context
    private var checked = -1

    private var catImages = arrayListOf(
        R.drawable.profile_picture,
        R.drawable.profile_picture,
        R.drawable.profile_picture,
        R.drawable.profile_picture,
        R.drawable.profile_picture
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.item_appointments, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder.itemView) {

            /*setOnClickListener {
                val dialog = BottomSheetDialog(context, R.style.CustomBottomSheetDialogTheme)
                dialog.setContentView(R.layout.fragment_bottom_sheet_announce)
                dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
                dialog.setOnShowListener { dialog ->
                    val d = dialog as BottomSheetDialog
                    val bottomSheetInternal =
                        d.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
                    BottomSheetBehavior.from<View>(bottomSheetInternal as View).state =
                        BottomSheetBehavior.STATE_EXPANDED
                }

                with(dialog) {

                    tvBlock.text = "Tamamlandı"
                    tvReport.text = "İptal Et"
                    btnConfirm.text = "Onayla"
                    tvHeading.text = "Yapmak istediğiniz işlemi seçin."

                    linearBlock.setOnClickListener {
                        checked = 0
                        ivBlock.setImageDrawable(
                            ContextCompat.getDrawable(
                                context,
                                R.drawable.image_checked
                            )
                        )
                        ivReport.setImageDrawable(null)
                    }

                    linearReport.setOnClickListener {
                        checked = 1
                        ivReport.setImageDrawable(
                            ContextCompat.getDrawable(
                                context,
                                R.drawable.image_checked
                            )
                        )
                        ivBlock.setImageDrawable(null)
                    }

                    btnConfirm.setOnClickListener {
                        dismiss()
                    }

                    show()
                }
            }*/
            ivProfilePic.setImageResource(catImages[position])
        }
    }

    override fun getItemCount(): Int {
        return catImages.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}
