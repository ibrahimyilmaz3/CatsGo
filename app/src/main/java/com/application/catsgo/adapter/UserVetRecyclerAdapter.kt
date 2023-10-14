package com.application.catsgo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.application.catsgo.ui.activity.UserVetInfoActivity
import kotlinx.android.synthetic.main.item_vet.view.*

class UserVetRecyclerAdapter : RecyclerView.Adapter<UserVetRecyclerAdapter.ViewHolder>() {

    private lateinit var context: Context

    private var catImages = arrayListOf(
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
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_vet, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder.itemView) {
            imgCat.setImageResource(catImages[position])
            mainConstItemPet.setOnClickListener {
                val intent = Intent(context as AppCompatActivity, UserVetInfoActivity::class.java)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return catImages.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}
