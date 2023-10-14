package com.application.catsgo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.application.catsgo.util.ChooseLocation
import kotlinx.android.synthetic.main.item_choose_location.view.*

class ChooseDistrictRecyclerAdapter() :
    RecyclerView.Adapter<ChooseDistrictRecyclerAdapter.ViewHolder>() {

    private lateinit var context: Context
    private var selected = -1

    private var arrayDistrict = arrayListOf(
        "Çukurova", "Sarıçam", "Seyhan", "Yüreğir"
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_choose_location, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*holder.mainConstItemPet.setOnClickListener {
            val intent = Intent(context as AppCompatActivity, UserCatsUnderCareActivity::class.java)
            context.startActivity(intent)
        }*/

        with(holder.itemView) {

            tvLocationName.text = arrayDistrict[position]

            if (selected == position) ivCheckItem.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.image_checked
                )
            )
            else ivCheckItem.setImageDrawable(null)

            setOnClickListener {
                selected = holder.adapterPosition
                notifyDataSetChanged()
            }

            if (selected == position) {
            ChooseLocation.district = arrayDistrict[selected]
            }
        }
    }

    override fun getItemCount(): Int {
        return arrayDistrict.size
    }

    /*override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }*/

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
