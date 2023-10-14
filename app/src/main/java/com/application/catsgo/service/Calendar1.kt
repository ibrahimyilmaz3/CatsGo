package com.application.catsgo.service

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import com.application.catsgo.adapter.CalendarAdapter
import com.application.catsgo.ui.dialog.Year2Fragment
import com.github.pwittchen.swipe.library.rx2.SwipeListener
import java.util.Calendar

@SuppressLint("ClickableViewAccessibility")
class Calendar1(private val context: AppCompatActivity, private val recyclerView: RecyclerView, private val headerText: TextView, private val nextButton: ImageView, private val previousButton: ImageView) {

    val result= MutableLiveData<String>()
    private val selected = Tools().todayDate()
    private var currentMonth = 0
    private var currentYear = 0

    init {
        with(context) {
            recyclerView.layoutManager =
                GridLayoutManager(context, 7, GridLayoutManager.VERTICAL, false)

            currentMonth = selected.split("/")[1].toInt()
            currentYear = selected.split("/")[2].toInt()
            val today = "${selected.split("/")[0].toInt()}/$currentMonth/$currentYear"
            headerText.text = "${getMonthName()} $currentYear"

            val adapter = CalendarAdapter(createMonthDays(), today)
            recyclerView.adapter = adapter
            adapter.result.observe(context){
                result.value= it
            }

            fun nextMonth() {
                if (currentMonth == 12) {
                    currentMonth = 1
                    currentYear++
                } else currentMonth++
                headerText.text = "${getMonthName()} $currentYear"
                adapter.itemList = createMonthDays()
                adapter.notifyDataSetChanged()
            }

            fun previousMonth() {
                if (currentMonth == 1) {
                    currentMonth = 12
                    currentYear--
                } else currentMonth--
                headerText.text = "${getMonthName()} $currentYear"
                adapter.itemList = createMonthDays()
                adapter.notifyDataSetChanged()
            }

            nextButton.setOnClickListener { nextMonth() }
            previousButton.setOnClickListener { previousMonth() }

            val swipe = com.github.pwittchen.swipe.library.rx2.Swipe()
            swipe.setListener(object : SwipeListener {
                override fun onSwipingLeft(event: MotionEvent?) {}
                override fun onSwipedLeft(event: MotionEvent?): Boolean {
                    nextMonth()
                    return true
                }

                override fun onSwipingRight(event: MotionEvent?) {}
                override fun onSwipedRight(event: MotionEvent?): Boolean {
                    previousMonth()
                    return true
                }

                override fun onSwipingUp(event: MotionEvent?) {}
                override fun onSwipedUp(event: MotionEvent?): Boolean {
                    return true
                }

                override fun onSwipingDown(event: MotionEvent?) {}
                override fun onSwipedDown(event: MotionEvent?): Boolean {
                    return true
                }
            })
            recyclerView.setOnTouchListener { _, motionEvent ->
                swipe.dispatchTouchEvent(motionEvent)
                false
            }

            headerText.setOnClickListener {
                val year2Fragment = Year2Fragment()
                year2Fragment.show(supportFragmentManager, "year2Fragment")
                year2Fragment.result.observe(this) {
                    //tvCity.text = it
                    currentYear = it.toInt()
                    headerText.text = "${getMonthName()} $currentYear"
                    adapter.itemList = createMonthDays()
                    adapter.notifyDataSetChanged()
                    year2Fragment.dismiss()

                }
            }

        }
    }

    private fun getMonthName(): String {
        return when (currentMonth) {
            1 -> context.getString(R.string.jan)
            2 -> context.getString(R.string.feb)
            3 -> context.getString(R.string.mar)
            4 -> context.getString(R.string.apr)
            5 -> context.getString(R.string.may)
            6 -> context.getString(R.string.jun)
            7 -> context.getString(R.string.jul)
            8 -> context.getString(R.string.aug)
            9 -> context.getString(R.string.sep)
            10 -> context.getString(R.string.oct)
            11 -> context.getString(R.string.nov)
            else -> context.getString(R.string.dec)
        }
    }

    private fun createMonthDays(): ArrayList<String> {
        val list = ArrayList<String>()
        list.add(context.getString(R.string.mon))
        list.add(context.getString(R.string.tue))
        list.add(context.getString(R.string.wed))
        list.add(context.getString(R.string.thu))
        list.add(context.getString(R.string.fri))
        list.add(context.getString(R.string.sat))
        list.add(context.getString(R.string.sun))

        val cal = Calendar.getInstance()
        cal.set(Calendar.DATE, 1)
        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MONTH, currentMonth - 1)
        cal.set(Calendar.YEAR, currentYear)

        when (cal.get(Calendar.DAY_OF_WEEK)) {
            3 -> list.add("-")
            4 -> for (i in 0..1) list.add("-")
            5 -> for (i in 0..2) list.add("-")
            6 -> for (i in 0..3) list.add("-")
            7 -> for (i in 0..4) list.add("-")
            1 -> for (i in 0..5) list.add("-")
        }

        when (currentMonth) {
            1 -> for (i in 1..31) list.add("$i/$currentMonth/$currentYear")
            2 -> {
                if (currentYear % 4 == 0) for (i in 1..29) list.add("$i/$currentMonth/$currentYear")
                else for (i in 1..28) list.add("$i/$currentMonth/$currentYear")
            }
            3 -> for (i in 1..31) list.add("$i/$currentMonth/$currentYear")
            4 -> for (i in 1..30) list.add("$i/$currentMonth/$currentYear")
            5 -> for (i in 1..31) list.add("$i/$currentMonth/$currentYear")
            6 -> for (i in 1..30) list.add("$i/$currentMonth/$currentYear")
            7 -> for (i in 1..31) list.add("$i/$currentMonth/$currentYear")
            8 -> for (i in 1..31) list.add("$i/$currentMonth/$currentYear")
            9 -> for (i in 1..30) list.add("$i/$currentMonth/$currentYear")
            10 -> for (i in 1..31) list.add("$i/$currentMonth/$currentYear")
            11 -> for (i in 1..30) list.add("$i/$currentMonth/$currentYear")
            12 -> for (i in 1..31) list.add("$i/$currentMonth/$currentYear")
        }
        return list
    }


}