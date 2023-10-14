package com.application.catsgo.ui.activity

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.catsgo.R
import com.application.catsgo.adapter.Vet3Adapter
import com.application.catsgo.model.Vet
import com.application.catsgo.service.Tools
import com.application.catsgo.util.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_vet.*

class VetActivity : BaseAppCompatActivity() {

    private val list = arrayListOf<Vet>()
    private val list2 = arrayListOf<Vet>()
    private val adapter = Vet3Adapter(list)
    private var selected = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vet)
        Tools().appColorStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        back()
        dataInitialize()
        rvInitialize()
        search()
        boardDown()
        check()
        focus()
        add()

    }

    private fun add() {
        btnAdd.setOnClickListener {
            Toast.makeText(this, "Klinik başarıyla eklendi!", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun focus() {
        etAddress.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearAddress.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }
        etName.setOnFocusChangeListener { view, b ->
            run {
                clearFocus()
                linearName.setBackgroundResource(R.drawable.round_20_edittext_corner_blue)
            }
        }
    }

    private fun clearFocus() {
        linearName.setBackgroundResource(R.drawable.round_20_edittext_corner)
        linearAddress.setBackgroundResource(R.drawable.round_20_edittext_corner)
    }

    private fun check() {
        check.setOnClickListener {
            if (selected == 0) {
                linearName.visibility = View.VISIBLE
                linearAddress.visibility = View.VISIBLE
                btnAdd.visibility = View.VISIBLE
                selected = 1
            } else {
                linearName.visibility = View.GONE
                linearAddress.visibility = View.GONE
                btnAdd.visibility = View.GONE
                selected = 0
            }
        }
    }

    private fun boardDown() {
        linearMain.setOnClickListener {
            val imm: InputMethodManager =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }

    private fun search() {
        etSearch.addTextChangedListener {
            when (etSearch.text.toString().length) {
                0 -> {
                    val adapterSearch = Vet3Adapter(list)
                    rvVet.adapter = adapterSearch
                }
                else -> {
                    list2.clear()
                    for (i in list) {
                        if (i.name.contains(
                                "${etSearch.text}",
                                true
                            ) || i.address.contains("${etSearch.text}", true)
                        ) {
                            list2.add(i)
                        }
                    }

                    val adapterSearch = Vet3Adapter(list2)
                    rvVet.adapter = adapterSearch
                }
            }
        }
    }

    private fun back() {
        linearBack.setOnClickListener {
            finish()
        }
        btnConfirm.setOnClickListener {
            finish()
        }
    }

    private fun rvInitialize() {
        rvVet.adapter = adapter
        rvVet.layoutManager = LinearLayoutManager(this)
    }

    private fun dataInitialize() {
        list.add(
            Vet(
                "Sweet Pets Veteriner Kliniği",
                "Halkalı Merkez Mah. Dereboyu Cad. Antplato A+ Office No:22 Küçükçekmece/İstanbul"
            )
        )
        list.add(Vet("Vetrio Veteriner Kliniği", "One Hacker Way Menlo Park, CA 94025 USA "))
        list.add(Vet("Halkalı Veteriner Kliniği", "410 Terry Ave N, Seattle 98109, WA."))
        list.add(
            Vet(
                "Sweet Pets Veteriner Kliniği",
                "Halkalı Merkez Mah. Dereboyu Cad. Antplato A+ Office No:22 Küçükçekmece/İstanbul"
            )
        )
        list.add(Vet("Vetrio Veteriner Kliniği", "One Hacker Way Menlo Park, CA 94025 USA "))
        list.add(Vet("Halkalı Veteriner Kliniği", "410 Terry Ave N, Seattle 98109, WA."))
        list.add(
            Vet(
                "Sweet Pets Veteriner Kliniği",
                "Halkalı Merkez Mah. Dereboyu Cad. Antplato A+ Office No:22 Küçükçekmece/İstanbul"
            )
        )
        list.add(Vet("Vetrio Veteriner Kliniği", "One Hacker Way Menlo Park, CA 94025 USA "))
        list.add(Vet("Halkalı Veteriner Kliniği", "410 Terry Ave N, Seattle 98109, WA."))
        list.add(
            Vet(
                "Sweet Pets Veteriner Kliniği",
                "Halkalı Merkez Mah. Dereboyu Cad. Antplato A+ Office No:22 Küçükçekmece/İstanbul"
            )
        )
        list.add(Vet("Vetrio Veteriner Kliniği", "One Hacker Way Menlo Park, CA 94025 USA "))
        list.add(Vet("Halkalı Veteriner Kliniği", "410 Terry Ave N, Seattle 98109, WA."))
        list.add(
            Vet(
                "Sweet Pets Veteriner Kliniği",
                "Halkalı Merkez Mah. Dereboyu Cad. Antplato A+ Office No:22 Küçükçekmece/İstanbul"
            )
        )
        list.add(Vet("Vetrio Veteriner Kliniği", "One Hacker Way Menlo Park, CA 94025 USA "))
        list.add(Vet("Halkalı Veteriner Kliniği", "410 Terry Ave N, Seattle 98109, WA."))
    }
}