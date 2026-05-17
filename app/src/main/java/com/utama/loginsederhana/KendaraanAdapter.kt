package com.utama.loginsederhana

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KendaraanAdapter(private val list: List<Kendaraan>) :
    RecyclerView.Adapter<KendaraanAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNama: TextView = itemView.findViewById(R.id.tvName)
        val tvDesc: TextView = itemView.findViewById(R.id.tvDesc)
        val tvHarga: TextView = itemView.findViewById(R.id.tvHarga)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_kendaraan, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val kendaraan = list[position]
        holder.tvNama.text = kendaraan.nama
        holder.tvDesc.text = kendaraan.deskripsi
        holder.tvHarga.text = kendaraan.harga
    }

    override fun getItemCount(): Int = list.size
}