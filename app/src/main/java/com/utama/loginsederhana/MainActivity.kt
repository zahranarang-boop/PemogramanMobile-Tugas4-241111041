package com.utama.loginsederhana

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvUsername = findViewById<TextView>(R.id.tvUsername)
        val menuMobil = findViewById<MaterialCardView>(R.id.menuMobil)
        val menuMotor = findViewById<MaterialCardView>(R.id.menuMotor)
        val menuAdmin = findViewById<MaterialCardView>(R.id.menuAdmin)

        val username = intent.getStringExtra("USER_NAME")
        tvUsername.text = username ?: "User"

        menuMobil.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("JENIS_KENDARAAN", "Mobil")
            startActivity(intent)
        }

        menuMotor.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("JENIS_KENDARAAN", "Motor")
            startActivity(intent)
        }

        menuAdmin.setOnClickListener {
            // Intent ke Dashboard Admin (Bisa diarahkan ke activity baru atau kategori)
            val intent = Intent(this, CategoryListActivity::class.java)
            startActivity(intent)
        }
    }
}