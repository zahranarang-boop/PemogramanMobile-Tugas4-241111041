package com.utama.loginsederhana

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kendaraan")
data class Kendaraan(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nama: String,
    val jenis: String, // Mobil atau Motor
    val deskripsi: String,
    val harga: String,
    val imageResId: Int = 0
)