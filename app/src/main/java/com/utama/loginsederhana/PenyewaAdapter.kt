package com.utama.loginsederhana

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PenyewaAdapter(private val list: List<Penyewa>) :
    RecyclerView.Adapter<PenyewaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNama: TextView = itemView.findViewById(R.id.tvNamaPenyewa)
        val tvKendaraan: TextView = itemView.findViewById(R.id.tvKendaraanSewa)
        val tvDurasi: TextView = itemView.findViewById(R.id.tvDurasi)
        val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_kategori, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.tvNama.text = data.namaPenyewa
        holder.tvKendaraan.text = "Kendaraan: ${data.kendaraanDisewa}"
        holder.tvDurasi.text = "Durasi: ${data.durasi}"
        holder.tvStatus.text = data.status
    }

    override fun getItemCount(): Int = list.size
}