package com.utama.loginsederhana

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface KendaraanDao {
    @Query("SELECT * FROM kendaraan")
    suspend fun getAllKendaraan(): List<Kendaraan>

    @Insert
    suspend fun insertKendaraan(kendaraan: Kendaraan)
}