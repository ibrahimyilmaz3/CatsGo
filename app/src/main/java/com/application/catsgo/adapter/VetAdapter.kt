package com.application.catsgo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import kotlinx.android.synthetic.main.item_country.view.*

class VetAdapter :
    RecyclerView.Adapter<VetAdapter.ViewHolder>() {

    private lateinit var context: Context
    val result = MutableLiveData<String>()

    private var arrayJob = arrayListOf(
        "Sweet Pets Veteriner Kliniği",
        "Vetrio Veteriner Kliniği",
        "Halkalı Veteriner Kliniği",
        "Sweet Pets Veteriner Kliniği",
        "Sweet Pets Veteriner Kliniği",
        "Vetrio Veteriner Kliniği",
        "Halkalı Veteriner Kliniği",
        "Sweet Pets Veteriner Kliniği",
        "Sweet Pets Veteriner Kliniği",
        "Vetrio Veteriner Kliniği",
        "Halkalı Veteriner Kliniği",
        "Sweet Pets Veteriner Kliniği",
        "Sweet Pets Veteriner Kliniği",
        "Vetrio Veteriner Kliniği",
        "Halkalı Veteriner Kliniği",
        "Sweet Pets Veteriner Kliniği",
        "Sweet Pets Veteriner Kliniği",
        "Vetrio Veteriner Kliniği",
        "Halkalı Veteriner Kliniği",
        "Sweet Pets Veteriner Kliniği",
        "Halkalı Veteriner Kliniği"
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.itemView) {

            tvCountry.text = arrayJob[position]

            setOnClickListener {
                result.value = tvCountry.text.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return arrayJob.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}
