package com.application.catsgo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import kotlinx.android.synthetic.main.item_country.view.*

class DialogCityRecyclerAdapter :
    RecyclerView.Adapter<DialogCityRecyclerAdapter.ViewHolder>() {

    private lateinit var context: Context
    val result = MutableLiveData<String>()

    private var arrayCountry = arrayListOf(
        "Adana"
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
            tvCountry.text = arrayCountry[position]

            setOnClickListener {
                result.value = tvCountry.text.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return arrayCountry.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}
