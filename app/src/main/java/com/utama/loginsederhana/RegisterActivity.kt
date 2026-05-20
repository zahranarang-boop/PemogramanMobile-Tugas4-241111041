package com.utama.loginsederhana

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        db = AppDatabase.getDatabase(this)

        val etUsername = findViewById<TextInputEditText>(R.id.etUsername)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val etConfirm = findViewById<TextInputEditText>(R.id.etConfirmPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val btnBackToLogin = findViewById<Button>(R.id.btnBackToLogin)

        btnRegister.setOnClickListener {
            val userStr = etUsername.text.toString().trim()
            val passStr = etPassword.text.toString().trim()
            val confStr = etConfirm.text.toString().trim()

            if (userStr.isEmpty() || passStr.isEmpty() || confStr.isEmpty()) {
                Toast.makeText(this, "Mohon isi semua data", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (passStr != confStr) {
                Toast.makeText(this, "Password tidak cocok", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            lifecycleScope.launch {
                val existingUser = db.userDao().getUserByUsername(userStr)
                if (existingUser != null) {
                    Toast.makeText(this@RegisterActivity, "Username sudah terdaftar", Toast.LENGTH_SHORT).show()
                } else {
                    val newUser = User(username = userStr, password = passStr)
                    db.userDao().insertUser(newUser)
                    Toast.makeText(this@RegisterActivity, "Pendaftaran Berhasil", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }

        btnBackToLogin.setOnClickListener {
            finish()
        }
    }
}