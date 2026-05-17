package com.utama.loginsederhana

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val jenis = intent.getStringExtra("JENIS_KENDARAAN") ?: "Mobil"

        // Data Statis Kendaraan
        val listMobil = listOf(
            Kendaraan(1, "Toyota Avanza", "Mobil", "Mobil keluarga nyaman 7 seater", "Rp 350.000 / Hari"),
            Kendaraan(2, "Honda Brio", "Mobil", "City car irit dan lincah", "Rp 250.000 / Hari"),
            Kendaraan(3, "Mitsubishi Pajero", "Mobil", "SUV tangguh untuk segala medan", "Rp 800.000 / Hari")
        )

        val listMotor = listOf(
            Kendaraan(4, "Honda Vario 160", "Motor", "Motor matic bertenaga", "Rp 80.000 / Hari"),
            Kendaraan(5, "Yamaha NMAX", "Motor", "Nyaman untuk perjalanan jauh", "Rp 100.000 / Hari"),
            Kendaraan(6, "Kawasaki Ninja 250", "Motor", "Motor sport berperforma tinggi", "Rp 250.000 / Hari")
        )

        val dataTampil = if (jenis == "Mobil") listMobil else listMotor
        
        supportActionBar?.title = "Sewa $jenis"

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = KendaraanAdapter(dataTampil)
    }
}