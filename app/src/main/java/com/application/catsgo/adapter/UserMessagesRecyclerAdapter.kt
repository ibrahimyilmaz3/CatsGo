package com.application.catsgo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.application.catsgo.ui.activity.UserMessageContentActivity
import kotlinx.android.synthetic.main.item_messages.view.*

class UserMessagesRecyclerAdapter : RecyclerView.Adapter<UserMessagesRecyclerAdapter.ViewHolder>() {

    private lateinit var context: Context

    private var catImages = arrayListOf(
        Pair(R.drawable.catsgo_square_icon, "CatsGo"),
        Pair(R.drawable.catsgo_square_icon, "CatsGo"),
        Pair(R.drawable.catsgo_square_icon, "CatsGo"),
        Pair(R.drawable.catsgo_square_icon, "CatsGo"),
        Pair(R.drawable.catsgo_square_icon, "CatsGo"),
        Pair(R.drawable.catsgo_square_icon, "CatsGo"),
        Pair(R.drawable.catsgo_square_icon, "CatsGo"),
        Pair(R.drawable.catsgo_square_icon, "CatsGo"),
        Pair(R.drawable.catsgo_square_icon, "CatsGo"),
        Pair(R.drawable.catsgo_square_icon, "CatsGo")
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_messages, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.itemView) {
            linearMainMessage.setOnClickListener {
                val intent =
                    Intent(context as AppCompatActivity, UserMessageContentActivity::class.java)
                context.startActivity(intent)
            }
            itemProfilePicture.setImageResource(catImages[position].first)
            tvName.text = catImages[position].second
        }
    }

    override fun getItemCount(): Int {
        return catImages.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}
