package com.application.catsgo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import kotlinx.android.synthetic.main.item_country.view.*

class DialogCatKiloRecyclerAdapter :
    RecyclerView.Adapter<DialogCatKiloRecyclerAdapter.ViewHolder>() {

    private lateinit var context: Context
    val result = MutableLiveData<String>()

    private var arrayYear = arrayListOf(
        "1 Kilo",
        "2 Kilo",
        "3 Kilo",
        "4 Kilo",
        "5 Kilo",
        "6 Kilo",
        "7 Kilo",
        "8 Kilo",
        "9 Kilo",
        "10 Kilo",
        "11 Kilo",
        "12 Kilo",
        "13 Kilo",
        "14 Kilo",
        "15 Kilo"
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
