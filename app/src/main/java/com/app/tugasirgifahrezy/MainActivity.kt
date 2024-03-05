package com.app.tugasirgifahrezy

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.tugasirgifahrezy.databinding.ActivityMainBinding
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val barang = resources.getStringArray(R.array.barang)
        val harga = resources.getStringArray(R.array.harga)

        val dataBarang = barang.zip(harga) { name, price ->
            Items(name, price.toInt())
        }

        val arrayAdapt = ArrayAdapter(this, R.layout.dropdown_item, dataBarang.map { it.name })
        arrayAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        bind.spinner.adapter = arrayAdapt

        val list = ArrayList<Items>()

        bind.rv.let {
            it.layoutManager = LinearLayoutManager(this)
            adapter = ItemAdapter(list)
            it.adapter = adapter
        }

        bind.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            @SuppressLint("NotifyDataSetChanged", "SetTextI18n")
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectData = dataBarang[position]
                println("ini data = ${selectData.name} dan ${selectData.harga}")

                bind.btnTambah.setOnClickListener {
                    list.add(Items(selectData.name, selectData.harga))
                    adapter.notifyDataSetChanged()

                    var total = 0
                    var admin = 2000
                    for (i in 0 until list.size){
                        total += list[i].harga
                        admin += 500
                    }

                    bind.total.text = "Total Harga $total + $admin"
                    val dataHarga = "$total $admin"

                    bind.btnPesan.setOnClickListener {
                        val i = Intent(this@MainActivity, HasilActivity::class.java)
                        i.putExtra("data", dataHarga)
                        i.putParcelableArrayListExtra("barang", list)
                        startActivity(i)
                    }
                }

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}