package com.application.catsgo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import kotlinx.android.synthetic.main.item_pet.view.imgCat
import kotlinx.android.synthetic.main.item_pet_care.view.*

class UserPetRecyclerAdapter : RecyclerView.Adapter<UserPetRecyclerAdapter.ViewHolder>() {

    private lateinit var context: Context
    private var list = arrayListOf<Int>()

    private var catImages = arrayListOf(
        R.drawable.example_cat,
        R.drawable.example_cat,
        R.drawable.example_cat
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_pet_care, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.itemView) {
            setOnClickListener {
                if (list.contains(holder.adapterPosition)) {
                    ivLogo.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.logo_empty_2))
                    list.remove(holder.adapterPosition)
                } else {
                    ivLogo.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.logo_catsgo))
                    list.add(holder.adapterPosition)
                }
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
