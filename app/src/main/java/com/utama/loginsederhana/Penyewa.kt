package com.utama.loginsederhana

data class Penyewa(
    val id: Int,
    val namaPenyewa: String,
    val kendaraanDisewa: String,
    val durasi: String,
    val status: String // Selesai atau Sedang Disewa
)