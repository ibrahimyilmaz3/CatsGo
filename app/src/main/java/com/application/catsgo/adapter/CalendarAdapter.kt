package com.application.catsgo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.application.catsgo.service.Tools

class CalendarAdapter(var itemList: ArrayList<String>, var selected: String) :
    RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {

    private lateinit var context: Context
    val result = MutableLiveData<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_calendar, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: CalendarAdapter.ViewHolder, position: Int) {
        if (itemList[position] != "-") {
            holder.day.text = itemList[position].split("/")[0]

            try {
                val formattedSelected =
                    selected.split("/")[0].toInt().toString() + "/" + selected.split("/")[1].toInt()
                        .toString() + "/" + selected.split("/")[2].toInt().toString()
                if (formattedSelected == itemList[position]) {
                    holder.day.background = ContextCompat.getDrawable(context, R.drawable.rounded)
                    holder.day.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.light_blue)
                    holder.day.setTextColor(ContextCompat.getColor(context, R.color.black))
                } else {
                    holder.day.background = ContextCompat.getDrawable(context, R.drawable.rounded)
                    holder.day.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.none)
                    holder.day.setTextColor(ContextCompat.getColor(context, R.color.black))
                    if (Tools().todayDate() == itemList[position]) {
                        holder.day.background =
                            ContextCompat.getDrawable(context, R.drawable.border_orange)
                        holder.day.backgroundTintList = null
                    }
                }
            } catch (e: Exception) {
            }
        }

        holder.day.setOnClickListener {
            try {
                var day = holder.day.text.toString().toInt()
                selected = itemList[holder.adapterPosition]
                result.value = itemList[holder.adapterPosition]
                notifyDataSetChanged()
            } catch (e: Exception) {
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val day: TextView = itemView.findViewById(R.id.itemCalendar_day)
    }
}