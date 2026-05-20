package com.utama.loginsederhana

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.utama.loginsederhana.databinding.ItemKendaraanBinding

class KendaraanAdapter(private val list: List<Kendaraan>) :
    RecyclerView.Adapter<KendaraanAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemKendaraanBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemKendaraanBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val kendaraan = list[position]
        with(holder.binding) {
            tvName.text = kendaraan.nama
            tvDesc.text = kendaraan.deskripsi
            tvHarga.text = kendaraan.harga
            
            // Set icon based on type
            if (kendaraan.jenis == "Motor") {
                ivIcon.setImageResource(android.R.drawable.ic_menu_compass)
            } else {
                ivIcon.setImageResource(android.R.drawable.ic_menu_directions)
            }
        }
    }

    override fun getItemCount(): Int = list.size
}