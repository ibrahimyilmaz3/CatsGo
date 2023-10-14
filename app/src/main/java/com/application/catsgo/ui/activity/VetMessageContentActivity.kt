package com.application.catsgo.ui.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.content.res.AppCompatResources
import com.application.catsgo.R
import com.application.catsgo.service.Tools
import com.application.catsgo.util.BaseAppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_vet_message_content.*
import kotlinx.android.synthetic.main.fragment_bottom_sheet_announce.*

@Deprecated("Removed from design")
class VetMessageContentActivity : BaseAppCompatActivity() {

    private var checked = 0
    private var checked1 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vet_message_content)
        Tools().whiteStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        ivBack.setOnClickListener {
            finish()
        }

        etSendMessage.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

                if (etSendMessage.text.toString().isEmpty()) {
                    /*ivChangePicture.setColorFilter(
                        ContextCompat.getColor(
                            applicationContext,
                            R.color.send_message_background
                        ), android.graphics.PorterDuff.Mode.DST_ATOP
                    )*/

                    ivChangePicture.setImageDrawable(
                        AppCompatResources.getDrawable(
                            applicationContext,
                            R.drawable.camera
                        )
                    )
                } else {
                    /*ivChangePicture.setColorFilter(
                        ContextCompat.getColor(
                            applicationContext,
                            R.color.color_c1c1c1
                        ), android.graphics.PorterDuff.Mode.DST
                    )*/
                    ivChangePicture.setImageDrawable(
                        AppCompatResources.getDrawable(
                            applicationContext,
                            R.drawable.send_message
                        )
                    )
                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
            }
        })

        ivBlockReport.setOnClickListener {

            val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
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
                linearBlock.setOnClickListener {
                    checked = if (checked == 0) {
                        ivBlock.setImageDrawable(
                            AppCompatResources.getDrawable(
                                applicationContext,
                                R.drawable.image_checked
                            )
                        )
                        1
                    } else {
                        ivBlock.setImageDrawable(null)
                        0
                    }
                }
                linearReport.setOnClickListener {
                    checked1 = if (checked1 == 0) {
                        ivReport.setImageDrawable(
                            AppCompatResources.getDrawable(
                                applicationContext,
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

    }
}