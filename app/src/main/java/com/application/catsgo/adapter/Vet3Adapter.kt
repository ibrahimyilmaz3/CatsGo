package com.application.catsgo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.application.catsgo.model.Vet
import kotlinx.android.synthetic.main.item_vet2.view.*

class Vet3Adapter(private val vet: ArrayList<Vet>) :
    RecyclerView.Adapter<Vet3Adapter.ViewHolder>() {

    private lateinit var context: Context
    private val list = arrayListOf<Int>()
    //val result = MutableLiveData<String>()

    private var selected = 1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_vet2, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.itemView) {

            //val sortedList = vet.sortedWith(compareBy { it.name })

            tvName.text = vet[position].name
            tvAddress.text = vet[position].address

            /*setOnClickListener {
                result.value = tvCountry.text.toString()
            }*/

            if (selected == holder.adapterPosition) {
                ivToggle.visibility = View.VISIBLE
            } else {
                ivToggle.visibility = View.INVISIBLE
            }

            setOnClickListener {
                selected = holder.adapterPosition
                notifyDataSetChanged()
                Toast.makeText(context, "Varsayılan klinik değiştirildi!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun getItemCount(): Int {
        return vet.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
