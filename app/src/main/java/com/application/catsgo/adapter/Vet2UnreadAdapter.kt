package com.application.catsgo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import kotlinx.android.synthetic.main.item_notifications.view.*

class Vet2UnreadAdapter :
    RecyclerView.Adapter<Vet2UnreadAdapter.ViewHolder>() {

    private lateinit var context: Context

    private var catImages = arrayListOf(
        Pair(R.drawable.cats_go_icon, "Ödemeniz hesabınıza yatırıldı!"),
        Pair(R.drawable.cats_go_icon, "Ödemeniz hesabınıza yatırıldı!"),
        Pair(R.drawable.cats_go_icon, "Ödemeniz hesabınıza yatırıldı!"),
        Pair(R.drawable.cats_go_icon, "Ödemeniz hesabınıza yatırıldı!"),
        Pair(R.drawable.cats_go_icon, "Ödemeniz hesabınıza yatırıldı!"),
        Pair(R.drawable.cats_go_icon, "Ödemeniz hesabınıza yatırıldı!"),
        Pair(R.drawable.cats_go_icon, "Ödemeniz hesabınıza yatırıldı!"),
        Pair(R.drawable.cats_go_icon, "Ödemeniz hesabınıza yatırıldı!")
        )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.item_notifications, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.itemView) {
            ivIcon.setImageResource(catImages[position].first)
            tvText.text = catImages[position].second
        }
    }

    override fun getItemCount(): Int {
        return catImages.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}
