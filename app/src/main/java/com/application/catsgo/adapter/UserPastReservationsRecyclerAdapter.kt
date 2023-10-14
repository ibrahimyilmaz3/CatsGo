package com.application.catsgo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import kotlinx.android.synthetic.main.item_appointments.view.*
import kotlinx.android.synthetic.main.item_past_reservations.view.*

class UserPastReservationsRecyclerAdapter :
    RecyclerView.Adapter<UserPastReservationsRecyclerAdapter.ViewHolder>() {

    private lateinit var context: Context

    private var vetImages = arrayListOf(
        R.drawable.image_checked,
        R.drawable.icon_close_red,
        R.drawable.image_checked,
        R.drawable.icon_close_red,
        R.drawable.image_checked
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_past_reservations, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.itemView) {
            ivCheck.setImageResource(vetImages[position])
            /*linearMessages.setOnClickListener {
                val intent =
                    Intent(context as AppCompatActivity, VetMessageContentActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK and Intent.FLAG_ACTIVITY_CLEAR_TASK
                context.startActivity(intent)
            }*/
        }
    }

    override fun getItemCount(): Int {
        return vetImages.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
