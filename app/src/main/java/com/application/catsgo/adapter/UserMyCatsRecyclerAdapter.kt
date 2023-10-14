package com.application.catsgo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.application.catsgo.ui.activity.UserUpdateCatInfoActivity
import kotlinx.android.synthetic.main.item_pet_care.view.*

class UserMyCatsRecyclerAdapter : RecyclerView.Adapter<UserMyCatsRecyclerAdapter.ViewHolder>() {

    private lateinit var context: Context

    private var catImages = arrayListOf(
        R.drawable.example_cat,
        R.drawable.example_cat,
        R.drawable.example_cat,
        R.drawable.example_cat,
        R.drawable.example_cat
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_backup, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.itemView) {
            mainConstItemPet.setOnClickListener {
                val intent =
                    Intent(context as AppCompatActivity, UserUpdateCatInfoActivity::class.java)
                context.startActivity(intent)
            }
            imgCat.setImageResource(catImages[position])
        }
    }

    override fun getItemCount(): Int {
        return catImages.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

}
