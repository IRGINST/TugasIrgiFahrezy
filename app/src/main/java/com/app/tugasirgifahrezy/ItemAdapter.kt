package com.app.tugasirgifahrezy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.tugasirgifahrezy.databinding.ListItemBinding

class ItemAdapter(private val listData: ArrayList<Items>) : RecyclerView.Adapter<ItemAdapter.ListViewHolder>() {

    class ListViewHolder(bind: ListItemBinding): RecyclerView.ViewHolder(bind.root) {
        val barang = bind.barang
        val harga = bind.harga
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val bind = ListItemBinding.inflate(inflate, parent, false)
        return ListViewHolder(bind)
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = listData[position]

        holder.barang.text = item.name
        holder.harga.text = item.harga.toString()
    }
}