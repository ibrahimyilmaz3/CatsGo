package com.application.catsgo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import kotlinx.android.synthetic.main.item_calendar.view.*

class TimeAdapter : RecyclerView.Adapter<TimeAdapter.ViewHolder>() {

    private lateinit var context: Context
    private var selected = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_calendar, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.itemView) {
            when (position) {
                0 -> {
                    itemCalendar_day.text = "00:00"
                    notAvailable.visibility = View.VISIBLE
                }
                1 -> {
                    itemCalendar_day.text = "09:00"
                    notAvailable.visibility = View.GONE
                }
                2 -> {
                    itemCalendar_day.text = "10:00"
                    notAvailable.visibility = View.GONE
                }
                3 -> {
                    itemCalendar_day.text = "12:00"
                    notAvailable.visibility = View.GONE
                }
                4 -> {
                    itemCalendar_day.text = "13:00"
                    notAvailable.visibility = View.VISIBLE
                }
                5 -> {
                    itemCalendar_day.text = "14:00"
                    notAvailable.visibility = View.VISIBLE
                }
                6 -> {
                    itemCalendar_day.text = "15:00"
                    notAvailable.visibility = View.GONE
                }
                7 -> {
                    itemCalendar_day.text = "16:00"
                    notAvailable.visibility = View.VISIBLE
                }
                8 -> {
                    itemCalendar_day.text = "17:00"
                    notAvailable.visibility = View.VISIBLE
                }
                9 -> {
                    itemCalendar_day.text = "18:00"
                    notAvailable.visibility = View.GONE
                }
                10 -> {
                    itemCalendar_day.text = "19:00"
                    notAvailable.visibility = View.VISIBLE
                }
                11 -> {
                    itemCalendar_day.text = "20:00"
                    notAvailable.visibility = View.GONE
                }
            }

            itemCalendar_day.background = ContextCompat.getDrawable(context, R.drawable.rounded)
            itemCalendar_day.setPadding(5, 5, 5, 5)

            if (selected == position) itemCalendar_day.backgroundTintList =
                ContextCompat.getColorStateList(context, R.color.light_blue)
            else itemCalendar_day.backgroundTintList =
                ContextCompat.getColorStateList(context, R.color.white)

            setOnClickListener {
                if (!notAvailable.isVisible) {
                    selected = holder.adapterPosition
                    notifyDataSetChanged()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return 12
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
