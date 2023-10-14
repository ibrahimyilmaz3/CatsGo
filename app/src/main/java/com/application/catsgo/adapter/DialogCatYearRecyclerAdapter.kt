package com.application.catsgo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import kotlinx.android.synthetic.main.item_country.view.*

class DialogCatYearRecyclerAdapter :
    RecyclerView.Adapter<DialogCatYearRecyclerAdapter.ViewHolder>() {

    private lateinit var context: Context
    val result = MutableLiveData<String>()

    private var arrayYear = arrayListOf(
        "1 Yıl",
        "2 Yıl",
        "3 Yıl",
        "4 Yıl",
        "5 Yıl",
        "6 Yıl",
        "7 Yıl",
        "8 Yıl",
        "9 Yıl",
        "10 Yıl",
        "11 Yıl",
        "12 Yıl",
        "13 Yıl",
        "14 Yıl",
        "15 Yıl",
        "16 Yıl",
        "17 Yıl",
        "18 Yıl",
        "19 Yıl",
        "20 Yıl"
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
        /*holder.mainConstItemPet.setOnClickListener {
            val intent = Intent(context as AppCompatActivity, UserCatsUnderCareActivity::class.java)
            context.startActivity(intent)
        }*/
        with(holder.itemView) {
            tvCountry.text = arrayYear[position]

            setOnClickListener {
                result.value = tvCountry.text.toString()
            }

        }
    }

    override fun getItemCount(): Int {
        return arrayYear.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}
