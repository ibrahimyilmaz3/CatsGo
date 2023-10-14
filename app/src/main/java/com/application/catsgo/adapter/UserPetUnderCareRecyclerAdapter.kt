package com.application.catsgo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.application.catsgo.ui.activity.UserCatsUnderCareActivity
import kotlinx.android.synthetic.main.item_pet.view.*
import kotlinx.android.synthetic.main.item_pet_care.view.imgCat
import kotlinx.android.synthetic.main.item_pet_care.view.mainConstItemPet

class UserPetUnderCareRecyclerAdapter :
    RecyclerView.Adapter<UserPetUnderCareRecyclerAdapter.ViewHolder>() {

    private lateinit var context: Context

    private var catImages = arrayListOf(
        R.drawable.example_cat,
        R.drawable.example_cat,
        R.drawable.example_cat,
        R.drawable.example_cat,
        R.drawable.example_cat
    )

    private var date = arrayListOf<String>(
        "25 Kasım - 28 Kasım arası",
        "25 Kasım - 28 Kasım arası",
        "10 Kasım - 15 Kasım arası",
        "10 Kasım - 15 Kasım arası",
        "10 Kasım - 15 Kasım arası"
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_pet, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.itemView) {
            mainConstItemPet.setOnClickListener {
                val intent =
                    Intent(context as AppCompatActivity, UserCatsUnderCareActivity::class.java)
                context.startActivity(intent)
            }
            imgCat.setImageResource(catImages[position])

            if (position == 0 || position == 1) {
                ivToggle.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.catsgo_active
                    )
                )
            } else {
                ivToggle.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.catsgo_past
                    )
                )
            }

            tvDate.text = date[position]

        }
    }

    override fun getItemCount(): Int {
        return catImages.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}
