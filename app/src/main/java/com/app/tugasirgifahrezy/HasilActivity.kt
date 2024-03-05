package com.app.tugasirgifahrezy

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.tugasirgifahrezy.databinding.ActivityHasilBinding

class HasilActivity : AppCompatActivity() {

    private lateinit var bind: ActivityHasilBinding
    private lateinit var adapter: ItemAdapter

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityHasilBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val list = intent.getParcelableArrayListExtra<Items>("barang")
        val data = intent.getStringExtra("data")
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show()

        bind.total.text = "Total Harga $data"

        bind.rv.let {
            it.layoutManager = LinearLayoutManager(this)
            adapter = list?.let { it1 -> ItemAdapter(it1) }!!
            it.adapter = adapter
        }
    }
}