package com.application.catsgo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import kotlinx.android.synthetic.main.item_country.view.*

class DialogCatMonthRecyclerAdapter :
    RecyclerView.Adapter<DialogCatMonthRecyclerAdapter.ViewHolder>() {

    private lateinit var context: Context
    val result = MutableLiveData<String>()

    private var arrayMonth = arrayListOf(
        "1 Aylık",
        "2 Aylık",
        "3 Aylık",
        "4 Aylık",
        "5 Aylık",
        "6 Aylık",
        "7 Aylık",
        "8 Aylık",
        "9 Aylık",
        "10 Aylık",
        "11 Aylık"
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
            tvCountry.text = arrayMonth[position]

            setOnClickListener {
                result.value = tvCountry.text.toString()
            }

        }
    }

    override fun getItemCount(): Int {
        return arrayMonth.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}
