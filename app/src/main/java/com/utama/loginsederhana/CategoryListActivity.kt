package com.utama.loginsederhana

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoryListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Data Statis untuk Admin (Daftar Penyewa Aktif)
        val listPenyewa = listOf(
            Penyewa(1, "Ahmad Dani", "Toyota Avanza", "3 Hari", "Sedang Disewa"),
            Penyewa(2, "Siti Aminah", "Honda Vario 160", "1 Hari", "Selesai"),
            Penyewa(3, "Budi Santoso", "Mitsubishi Pajero", "5 Hari", "Sedang Disewa"),
            Penyewa(4, "Zahra", "Yamaha NMAX", "2 Hari", "Selesai")
        )

        // Setup RecyclerView dengan PenyewaAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PenyewaAdapter(listPenyewa)
        
        supportActionBar?.title = "Dashboard Admin"
    }
}