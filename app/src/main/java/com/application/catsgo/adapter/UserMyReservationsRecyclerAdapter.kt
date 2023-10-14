package com.application.catsgo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_message_content.*
import kotlinx.android.synthetic.main.fragment_bottom_sheet_announce.*
import kotlinx.android.synthetic.main.item_appointments.view.*
import kotlinx.android.synthetic.main.item_appointments.view.ivProfilePic
import kotlinx.android.synthetic.main.item_user_appointments.view.*

class UserMyReservationsRecyclerAdapter :
    RecyclerView.Adapter<UserMyReservationsRecyclerAdapter.ViewHolder>() {

    private lateinit var context: Context
    private var checked = 0
    private var checked1 = 0

    private var vetImages = arrayListOf(
        R.drawable.example_vet,
        R.drawable.example_vet,
        R.drawable.example_vet,
        R.drawable.example_vet,
        R.drawable.example_vet
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user_appointments, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.itemView) {
            ivProfilePic.setImageResource(vetImages[position])
            linearCancel.setOnClickListener {
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
                    linearBlock.visibility = View.GONE
                    tvReport.text = "İptal Et"
                    btnConfirm.text = "Onayla"
                    tvHeading.text = "Rezervasyonu iptal etmek mi istiyorsunuz?"
                    /*setOnClickListener {
                        checked = if (checked == 0) {
                            ivBlock.setImageDrawable(
                                AppCompatResources.getDrawable(
                                    context,
                                    R.drawable.image_checked
                                )
                            )
                            1
                        } else {
                            ivBlock.setImageDrawable(null)
                            0
                        }
                    }*/
                    linearReport.setOnClickListener {
                        checked1 = if (checked1 == 0) {
                            ivReport.setImageDrawable(
                                AppCompatResources.getDrawable(
                                    context,
                                    R.drawable.image_checked
                                )
                            )
                            1
                        } else {
                            ivReport.setImageDrawable(null)
                            0
                        }
                    }

                    btnConfirm.setOnClickListener {
                        dismiss()
                    }

                    show()
                }

            }
            setOnClickListener {

            }
        }
    }

    override fun getItemCount(): Int {
        return vetImages.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
