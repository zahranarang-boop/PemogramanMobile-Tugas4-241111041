package com.utama.loginsederhana

data class Kendaraan(
    val id: Int,
    val nama: String,
    val jenis: String, // Mobil atau Motor
    val deskripsi: String,
    val harga: String,
    val imageResId: Int = 0
)